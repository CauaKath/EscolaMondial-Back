CREATE TABLE frequencias (
    id BIGINT NOT NULL AUTO_INCREMENT,
    aluno_matricula BIGINT NOT NULL,
    status BOOLEAN NOT NULL,

    PRIMARY KEY(id)
);

ALTER TABLE frequencias ADD CONSTRAINT fk_aluno_matricula
FOREIGN KEY(aluno_matricula) REFERENCES alunos(matricula);

DROP TRIGGER IF EXISTS `escola`.`frequencias_BEFORE_INSERT`;

DELIMITER $$
USE `escola`$$
CREATE DEFINER = CURRENT_USER TRIGGER `escola`.`frequencias_BEFORE_INSERT` BEFORE INSERT ON `frequencias` FOR EACH ROW
BEGIN
	SET @max := (SELECT MAX(id) FROM frequencias);
    SET @count := (SELECT COUNT(id) FROM frequencias);

    if (@max = @count) THEN
		SET @next_value := @max + 1;
    elseif (@count = 0) THEN
        SET @next_value := 1;
    else
		SET @next_value := @count;
    end if;

    SET NEW.id = @next_value;
END$$
DELIMITER ;