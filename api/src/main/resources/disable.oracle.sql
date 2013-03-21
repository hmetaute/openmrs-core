DECLARE
BEGIN
  FOR i IN
  (SELECT table_name,
    constraint_name --disable first the foreign key
  FROM user_constraints
  WHERE constraint_type ='R'
  AND status            = 'ENABLED'
  )
  LOOP
    EXECUTE IMMEDIATE 'ALTER TABLE ' ||i.table_name|| ' DISABLE CONSTRAINT ' ||i.constraint_name;
  END LOOP i;
  FOR i IN
  (SELECT table_name,
    constraint_name -- then disable all constraints
  FROM user_constraints
  WHERE status = 'ENABLED' and not table_name like 'BIN%'
  )
  LOOP
    --SYS.dbms_output.put_line('ALTER TABLE ' ||i.table_name|| ' DISABLE CONSTRAINT ' ||i.constraint_name);
    EXECUTE IMMEDIATE 'ALTER TABLE IPSA.' ||i.table_name|| ' DISABLE CONSTRAINT ' ||i.constraint_name;
  END LOOP i;
END;