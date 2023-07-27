#Person Wise Report
SELECT `person_id`,`person_name`,`person_namek`,`address`,`contact_no` FROM `person`-- where `person_id`=3
SELECT `person_id`,`service_id`,`ward_code`,`place_code`,`YEAR`,`service_type`,`message_title`,`message` FROM `public_service` WHERE `person_id`=3;
#Ward Wise Report
SELECT w.`ward_name`,w.`ward_namek` FROM `ward` w,`person` p
WHERE p.`person_id`=3 AND w.`ward_code`=p.`ward_code` AND w.`place_code`=p.`place_code`;
SELECT ps.`service_id`,ps.`YEAR`,ps.`service_type`,ps.`message_title`,ps.`message` FROM `public_service` ps,`person` p 
WHERE p.`person_id`=3 AND ps.`ward_code`=p.`ward_code` AND ps.`place_code`=p.`place_code` AND ps.`service_type`="G";
#Place Wise Report
SELECT pl.`place_name`,pl.`place_namek` FROM `place` pl,`person` p
WHERE p.`person_id`=3 AND pl.`place_code`=p.`place_code`;
SELECT ps.`service_id`,ps.`YEAR`,ps.`service_type`,ps.`message_title`,ps.`message` FROM `public_service` ps,`person` p 
WHERE p.`person_id`=3 AND ps.`ward_code`="WD-ALL" AND ps.`place_code`=p.`place_code` AND ps.`service_type`="G";
#Taluk Wise Report
SELECT `place_name`,`place_namek` FROM `place` 
WHERE `place_code`="PL-ALL";
SELECT ps.`service_id`,ps.`YEAR`,ps.`service_type`,ps.`message_title`,ps.`message` FROM `public_service` ps
WHERE ps.`place_code`="PL-ALL" AND ps.`service_type`="G";

