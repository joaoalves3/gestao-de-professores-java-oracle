-- =====================================================================
-- Gestão de Professores - script do banco (Oracle)
-- Rode no SQL Developer conectado com o seu usuário.
-- =====================================================================

CREATE TABLE java_professor (
    id_professor    NUMBER PRIMARY KEY,
    nome            VARCHAR2(100) NOT NULL,
    aulas_semanais  NUMBER(3)     NOT NULL,
    valor_hora      NUMBER(10, 2) NOT NULL,
    salario         NUMBER(10, 2)
);

-- O ID é gerado pelo próprio sistema (maior ID + 1, começando em 1000).

-- Consulta de exemplo: professores por regime de trabalho
SELECT CASE
         WHEN aulas_semanais <= 12 THEN 'horista'
         WHEN aulas_semanais <= 39 THEN 'parcial'
         ELSE 'integral'
       END AS regime,
       COUNT(*)      AS qtd_professores,
       SUM(salario)  AS folha_total
FROM java_professor
GROUP BY CASE
           WHEN aulas_semanais <= 12 THEN 'horista'
           WHEN aulas_semanais <= 39 THEN 'parcial'
           ELSE 'integral'
         END;
