DECLARE
BEGIN
  FOR i IN
  (SELECT table_name,
    constraint_name
  FROM user_constraints
  WHERE status = 'DISABLED'
  AND NOT table_name LIKE 'BIN%'
  )
  LOOP
    --SYS.dbms_output.put_line('ALTER TABLE ' ||i.table_name|| ' ENABLE CONSTRAINT ' ||i.constraint_name);
    EXECUTE IMMEDIATE 'ALTER TABLE IPSA.' ||i.table_name|| ' ENABLE CONSTRAINT ' ||i.constraint_name;
  END LOOP i;
  FOR i IN
  (SELECT table_name,
    constraint_name
  FROM user_constraints
  WHERE constraint_type ='R'
  AND status            = 'DISABLED'
  )
  LOOP
    --SYS.dbms_output.put_line('ALTER TABLE ' ||i.table_name|| ' ENABLE CONSTRAINT ' ||i.constraint_name);
    EXECUTE IMMEDIATE 'ALTER TABLE ' ||i.table_name|| ' ENABLE CONSTRAINT ' ||i.constraint_name;
  END LOOP i;
END;