/*
SQLyog Community v13.1.6 (64 bit)
MySQL - 5.7.40-log : Database - kundgol_db
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`kundgol_db` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `kundgol_db`;

/*Table structure for table `category` */

DROP TABLE IF EXISTS `category`;

CREATE TABLE `category` (
  `category_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `category_code` varchar(255) DEFAULT NULL,
  `category_name` varchar(255) DEFAULT NULL,
  `category_namek` varchar(255) DEFAULT NULL,
  `created_by` bigint(20) DEFAULT NULL,
  `created_date` date DEFAULT NULL,
  `updated_by` bigint(20) DEFAULT NULL,
  `updated_date` date DEFAULT NULL,
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `category` */

insert  into `category`(`category_id`,`category_code`,`category_name`,`category_namek`,`created_by`,`created_date`,`updated_by`,`updated_date`) values 
(1,'CAT-01','Education','ಶಿಕ್ಷಣ',1,'2023-07-14',NULL,NULL),
(2,'CAT-02','Drinage','ಒಳಚರಂಡಿ',1,'2023-07-14',NULL,NULL),
(3,'CAT-03','Road','ರಸ್ತೆ',1,'2023-07-14',NULL,NULL),
(4,'CAT-04','Electricity','ವಿದ್ಯುತ್',1,'2023-07-14',NULL,NULL),
(5,'CAT-05','Drinking Water','ಕುಡಿಯುವ ನೀರು',1,'2023-07-14',NULL,NULL);
(6,'CAT-06','Agriculture','ಕೃಷಿ',1,'2023-07-14',NULL,NULL);
(7,'CAT-07','Infrastructure','ಮೂಲ ಸೌಕರ್ಯ',1,'2023-07-14',NULL,NULL);
(8,'CAT-08','Health','ಆರೋಗ್ಯ',1,'2023-07-14',NULL,NULL);

/*Table structure for table `person` */

DROP TABLE IF EXISTS `person`;

CREATE TABLE `person` (
  `person_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `aadhaar_no` varchar(255) DEFAULT NULL,
  `contact_no` varchar(255) DEFAULT NULL,
  `created_by` bigint(20) DEFAULT NULL,
  `created_date` date DEFAULT NULL,
  `person_name` varchar(255) DEFAULT NULL,
  `place_code` varchar(255) DEFAULT NULL,
  `updated_by` bigint(20) DEFAULT NULL,
  `updated_date` date DEFAULT NULL,
  `ward_code` varchar(255) DEFAULT NULL,
  `person_namek` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`person_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `person` */

insert  into `person`(`person_id`,`aadhaar_no`,`contact_no`,`created_by`,`created_date`,`person_name`,`place_code`,`updated_by`,`updated_date`,`ward_code`,`person_namek`,`address`) values 
(1,'1234567812345678','1234567890',1,'2023-07-12','ABC','PL-01',NULL,NULL,'WD-01','ಎಬಿಸಿ',NULL),
(2,'5678123412345678','9012345678',1,'2023-07-12','XYZ','PL-02',NULL,NULL,'WD-03','XYZ',NULL);

/*Table structure for table `place` */

DROP TABLE IF EXISTS `place`;

CREATE TABLE `place` (
  `place_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_by` int(11) NOT NULL,
  `created_date` date NOT NULL,
  `place_code` varchar(10) NOT NULL,
  `place_name` varchar(50) DEFAULT NULL,
  `updated_by` int(11) unsigned zerofill DEFAULT NULL,
  `updated_date` date DEFAULT NULL,
  `place_namek` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`place_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `place` */

insert  into `place`(`place_id`,`created_by`,`created_date`,`place_code`,`place_name`,`updated_by`,`updated_date`,`place_namek`) values 
(1,1,'2023-07-07','PL-01','Kundgol',NULL,NULL,'ಕುಂದಗೋಳ'),
(2,1,'2023-07-07','PL-02','Jagaluru',NULL,NULL,'ಜಗಳೂರು'),
(3,1,'2023-07-07','PL-03','Samshi',NULL,NULL,'ಸ೦ಶಿ'),
(4,1,'2023-07-07','PL-04','Kamdolli',NULL,NULL,'ಕಮಡೊಳ್ಳಿ'),
(5,1,'2023-07-07','PL-05','Yaliwala',NULL,NULL,'ಯಲಿವಾಳ'),
(6,1,'2023-07-07','PL-06','Gudgeri',NULL,NULL,'ಗುಡಗೇರಿ');

/*Table structure for table `public_service` */

DROP TABLE IF EXISTS `public_service`;

CREATE TABLE `public_service` (
  `service_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_by` bigint(20) DEFAULT NULL,
  `created_date` date DEFAULT NULL,
  `file_name` varchar(255) DEFAULT NULL,
  `file_type` varchar(255) DEFAULT NULL,
  `image_data` longblob,
  `message` varchar(255) DEFAULT NULL,
  `person_id` bigint(20) DEFAULT NULL,
  `person_name` varchar(255) DEFAULT NULL,
  `person_namek` varchar(255) DEFAULT NULL,
  `place_code` varchar(255) DEFAULT NULL,
  `updated_by` bigint(20) DEFAULT NULL,
  `updated_date` date DEFAULT NULL,
  `ward_code` varchar(255) DEFAULT NULL,
  `message_title` varchar(255) DEFAULT NULL,
  `service_type` char(1) DEFAULT NULL,
  PRIMARY KEY (`service_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `public_service` */

insert  into `public_service`(`service_id`,`created_by`,`created_date`,`file_name`,`file_type`,`image_data`,`message`,`person_id`,`person_name`,`person_namek`,`place_code`,`updated_by`,`updated_date`,`ward_code`,`message_title`,`service_type`) values 
(1,1,'2023-07-16','la.jpg','image/jpeg','x��T^˒(��Np\r����݃wwww�����=��=�=W�����9�����Y�jm��]�]]U]��u�u\0����\0\0 ox] �! !�!!! �� �a���00�h�H�@L4,,L4l<2l\\BjB���T��h�i(��(()~!\r�\n�J���M���\r�\r�\Z�\0���������`���o\0\n	�v�ߖ�\n��\0x��&@0�[�3_@�[!�����~����\Z�Զf\r���o���o�O$��8��*.ϱO��0ٶ��}�H�u!\0�9}�8\rF�Z�����Hk5>\n�N��LG���xxha&���Y��%Xܦ���t�Y�u\0\0�m( ��E�m�\0�Z���h��ŷ�w��O�Ȣ;^%�D�ޯ̨� �����)T����\\�g^���L~�$�<�YS�c�p�N��\Z�2{��2��&c�\n��M����a�AP��\07Q%�/�8�\Z�=\\�b�y��\\��P��Mh��l����3��Y�?ӃT�E����.����@���zzl�dw�I�B�Zit����u�����\rm�1L\0��������\"X���gk��`1�K��%��|�	�g)��\nx���k\'w�ܤsq���^�=��l����sk�e7]��*!S5��!��e63�q�ӯ�\n�q��_����픩(���t�ǿ�\n�� :�bH\Z�	p�[w8���9�t���`n{�\Z�a�C��4��dX�@\Z^��WdO���~���n��T:j�s�Z���m����#{����?��[}j�\0v�Ip�H\Z�\n<זs�N���QS���)�7n�N���~���7\0����~��,�py��#a�� �N�����e$�{t;�����5��=����6D�o��ԅ~�	=�ހM%�E\'��a �\\��{���p#��y��jN�#1��s���(ej�|Ƹ����.q���g�Vq/=�l��7�B��m��C��O�k�WZ�Ol��)�P�23u�<h[�\r6q��E�<�&�F|�uN���~hޟ�G�D_��0/�L�(1�����N���&�᝹�@���0��o֦�j�/B�̋�M�V����6?oڡ�c����(�>\0��/3 ��\0w�uʷΒ��_���nW��yl��=h4�N_tNd�V�Ը����ёި�Vee�g���\0@�r�Q$��	��kլ�;KJJl�F?_�_�	�/	d�ݳ��^|�\r]��<��O� Ǵ]���M͙��\rh�>\03�cBܫx\'{m�x�vq�{��:܍�7��R}5�dº�l� \n\Z\0(�������h|%DRUU}`��F9�0/{��c��ں�}T�Ehd��*u�T��[�,�2�RL����?է5e jafRPƛ\\\\����w�14i��k�֭��N�Y�l��֎xmBNa���pA��U��\rH1�a���8:����%��cT`��y*8��$!�~;��AG�?~+�=��\r���B�o�sT|��������K@zˣ��\000Pppp�_�nPp\02$\nU�������Q���_���=����4�-��\0=�g(�h�O����eU�v��@�\ZtH�������E%-Oq�5�;m�V�7��$\'�w�&Ɲ� NVNK���f�d��y(n��!�쉛D`��{T3-*�s\\�K\Z8� \0��V�9ی�a>�ɵ�K�����a�I�E�x��ˬ3?�\0?�`rk�k|_�qޱ`o��q�a+UY���8T���b�1������$���	�C���;�����c���,_na�`UʿTW��M4S-~���@��Kh�_C�9c%\"�~!��0jX!X���\\��07�TT����g�s���P0���gS���N	o�w��t�9�\'�G��aYыYD%D�$�Kk���[J�N�C?�G12g��k�[��F�Y.�Y��$gY=��o�+&�GX2L�L���h}�����T�t�zi?X���]鲿P�dY�ceV(�|	EīoI�-d��ݩiN�2�Xe��V�\\l�))M�0�N3b�^�Ѩ�O��\"9SQ��#-Z�=�%�Ò@���jy��y��»��P�n���|�|\'���kK�x��2:��=��?� �����t��ګ�\"��06lWMPMY����{���&��FG6S-��S�K	�U%嬆���5M6J�Q:��rEd��w|��qܬ��q��1�%�Y�Z�C��@�����|�z����_Wk�Į/�w�ە\"�ُq�+��M��וι���z�^���<�k6��rT�A�۪��Z^֣�%���g;^��)J]��Ü���=1��vC�<O-���NZ\rK����)�մ�����M.\\���89�?����L��,�<�?<*%�֘,[�X��X{KWeD�I-��\r��X�7�@at�P�]��?�������X�2M*�z��:�`��`����$B��>�\Z\"����46U�V�-G�2���̨RWGx[�F<˥s.�{E�H�f+}Jѭ���|\nTV,����,�>AF��B0��w�� ��J̦C�ű��������{,��y�\\G\Z�f���6��*<\n�Zv�\ne\rd:�5�\'���OQ��Z��������U\Z�Y���V~��*CtS�Ӌ�w��j\rP���ګ�e͇r�4�+��������b�����y��և��<���d�E|lO�1B��P�r2���fkn�\"�@��Ia`��o�V�%!��b��St�\nca���rv+��%e�8�yRDը���ű�5+[S������`�Ql�)�x�քn!�1	��N�c�e�N������RN���l/j�Z��T��dg��n�q\"��*DN׾I�W	T��Lۨ.�of�h�\Z��**Qf���c�����v��qf9�d��椶C���E~ �Y�3���{���3���Y�ـ�N�Ѫz�.���Zv������)~�liG�\0�1%��ӂ6WĒ�\r�+����dc��ḁvɘTc��d�|�n�n�yx`%���c8����R�=������8	;*}ۃ����N(��K���!Rbb7��/YY�+�����ԇ51ƍ��auS�਌�t�y3e���fg������G����0�2._rҸ�EaՃB���^\\c�C��3	U��8��/���>�ׇu���]!H=be�8�k^��ǈKT�K��⣞?;1>�R2� DM�9D��Q��eΖ�ر�2��{8MzThU�ag�j!�-���._5�\r^(�*��A)��H��]b#>��B�z�z�T�ጬh�Y��&@�$;�34��\\��7`�� �GR�m�^ \'�2t�S{v��]�y?8j�8��ǚoL���b�C�}[~M��~��w�_��X� .�7���B\r�h~�2˹��B ��<\\W)K�Zr�4�h�O#�V2��լ��3J��e�5xy?S)�> 1S��qԩ�;�M�D>�DX�sF��ȼ��\":���*�QF|R����01`G�ڣ����\\��0#\Z\0\r+B�y�\'�\\�4��FCr�!��.]D�jg\Z�1t��c�״Qu�����|��F�+`�Ǫ����j�_�{0>Y��C\rп�@A@�@a�` �\0`��&�`\0dp\" *!1���������_\Z	�}^M�3�����������ڿE�|�W�r�Z���c�r�����X�/��s�\'Eɦ�g����� j���2�=�S�!2�5��F��rK=�N��7?AZ��Yp�ve��>/W<%k��Gf�T�<f-�\0e�6�j�r��G�^�o�����o�띩e�c[��=zO�ɑ���QΜ���j@m�^�uYXLVD�C��I~t�w�q:���I.gH\r>#�����v� �^�d�W����� g+�+���URV��grc���{7�(��DH�H�\"��ۚC�e�8Pk������euսy�j�Z��\'44��y\Z�X����g�	���+�4�L�H��Ѿ���F��C?��k^��s��F{F�{|��?Ӆ�?d�g�#������e(�>t��/�1�X�u�8Z�v���m����V��-5]uV@h�O�ӗ5�9m���R��M7�O�+�tCV��&� j���{�#���t�+�C�S6�RޞE9f�t؟�Mஊ�K/�=]%�����mg�骫+>�rE�%;~r�*��\\r5l��{��7k\n�i!�{^�M�|f�U5�a�,�!\n�VT�A�i�/N$O���o2�/����M�p�\n�J�����&����8ٞ2φ��W\n��ppPht��]ű؍zB�ik4��)�3�C��\0Q�IU��srnlI@z{��!�^eq�U<��\nI�8�F7��k�g��1�r�1^|�R1M�~ )yh@�P�b�▘��Y� r_7�b��� �欤��&]��a�:�\Z��OM�|���s���wP3p��KTU0�6o��$$�ݠ���lfY��ЯƊ��)泼�avw�7�-�\'����ܶ?�ɟŀ�9\\�z\'x�E��w�e/���~��]��Z�w \nQ�yN.������z�Z4��0���|����[\Z��aO��Wf��C���̊��\'��w��\'\ZOI!�W�l��]�g�64�9HV�X*\r*�F�>\\U~yf��\n|������mP�ԞN�����&�z�@>��!��\"$ ���B��P����9�R�_aF�[O���d�����\nͼܑ�nwR㫳�6�<�\n[W�~�����?/?�\'�R�� ��,W2ν	jC\'}NW	M�r������V��GRH:�jg��i��~�Ȱn\nsc�8��U��Q~R����z�0�[D9a��s��E4�g����(L6]�ۉ\"��%�_F��jk:Lg��e�as4��s�2\0a�*S�w�ÇږR�Ci�\\,��|()�B�w����m�um����s�Equ�O˲,^����	c�,�>�bQ*�;�k�֏�)p�(M�-�S�1J\ZYi�6�UL�֢@�:��E����%le�ӷ,��xWǏE���H�#2tSl���r�y\\�O��|9q�+����8l�[�_���QFI f-&F\"=b�6b�{3�g�|?��X�U��v����Sp�;/�E���i�6!Z�P����Ț;$\0UnO�)�r^���-��\'xB�d�to��/\'�{��o�����OqK@<(8�.ݑ��#���1�.�ߋ��c���� �:�^����v\\�7l�?�6���0��͊�׾]�&(��.V��2il=Vhz�$�������7��!�%�Ѡ:����\"��\0ʲ5�S�U�Fi�f��W@��e�^��m�@�	��r�m<μ�\'���a=u�t�p�`���Nm���� ��ڞ|2��b��m���^�����ʫ�{�d�P���tV������Yscc�>��)��qc6�n��C��m)N�nW	.�����M��ȟ�3V����G���Q�֮)⿱�.�v�aY�����#�\r��:=����s3��-F��;�3���O}�r�ن�gÔϗˏ�@�+�p�ix�i\n����\\\nBv���f���e��)�l�U�X�^n�W/��#B�����ޣv���T��[Yt;��G�+@�_��HW�N-���,�P4�6�\n̶���()j��V��*ZsQ��M���B�@�h|z�e�)�g�P�,��T�k��gc���t��ZPIO>j�$�Am������r��]��f�t�L��1���Pl��~��A�,A�1�����r�Gh7\'�\\Pt�Ҕ���Q�Me�t��fgxzL��4,u$pc�;� G�`#A�4;_4��x���uO�o�Y�5F(�/b����y��6Lцxw(+U7�]��}�0�g��dt�0K)o�y��]�@>gy[tQ��I�!�Jj-����^옓=�aՓ裥�����D���?�\Z�/^�qQ�F��Ņ!t���Ű��߳��란�����\n�[���0u���`�-���,J��;\Zͣ/�p�\nc��~Ky,	P U�^��b����͏┞E��r^�6��[�^��4j���^7�T�L�2��j�\"]��e�|���_O�:2S�E�-i�C2���:����\r\'�R5:��$΍ֵ�@t�Wچ/�5<�=��K����~���[�$�\r��6�q1z���e��ٳ�e|����5B5յcK=p8��cUK\r�ۖ|�a��Q�N�*�{4��S�ѬR���.�b�KaB�5\r$/����Q�xi���ܓ��:�%��ϼ��.]~\\��s�&�\\�ig�s�\'����>^hF\ZCe�%\r�1PA|�����a/����?_�Q\\3O���^��-��ѕ�fúzȥ�0f�a�ou�R���?d?�ї�zh�1 �^.��1�i�J����&�v-K)�S�ц����j�j.笒I)��Ylj���>�*������~y�� �d�$�I��7��q:棻���y7[��:��p�\\�:`E�?��2�RA����&�V����k�����G�)?�=f�\0%�j.o\0���y)Bb�����H2kq�X�]!G	S���G���O�,L!A�n���4�%Y:���2�֟e�����p�ri�����y��^О��X�E�3�2�$��J�ssè{cZ��}.X������0Ͽ�y!�aț+��i.��R�Eo�ͨ\r <DYY.U��,H�w�sk�_������o��<.�zG��b�]sIZT\"}�:6�v!tՒ�e$X_s�C�<-K�*S��̨�>q�!s�\Z��ʌ\Z��2��0k�$��N��\"�h�jg��\ZzC�N�av;e��}�J�u�hqRCÅ�7�Y��c�%-�\'�W�[C\r�%���\0�~I`\0�D\nv~@¸�N}ۚ�3�\r��?�#zH�ݭ͙^I���҄\"F�ɹCr��}���%��K���`ͤ��W.$Н8��v�,٬7J��/��W�\r��=����GRFm�4�.���؟衛j�;���ej{�༃�YI��?�{��,i5����3��ج�݌��5�\'\0���q�Y�E�?Y�m�$</^ ��v#N 6�V^��C���i����\\J�����{b}�V���yb�R 5��vۺVG�:$���B��9��{�U������;X���n����fOT���Q�]�����E�=JL��Ʀ�|ݬ��S:R�:�sC��{MiŵC��S�� �燣�س�t�W@�9F�u���#��D�<���	�rP��F&����9����Gj�G����o@6�4��խ	���dV�1��BM֪���a�Ԁ[�����򕵣������Q��r����+6O��\nb/�������_���N�ڡ-���9	NhƩ}0��`�˶By��� ���up��%�C��O��\Z����T�%=��,\"�a��`�����5Y���+�SHAa�)��YӃ!ZJ�z\0�tx��N������mb5�����>z����8J��W%*1JTjW:/�c�2��~���}��NVIx�(7Mj���p����/c8�$�oy&�>@I�x^��.�MS��Wy�~\n> ��^��IH����&�̢z��J4q٬	/�qz�y�Nc��J��N{h�x���^�5����E���P����m@|�~����\0X�:���$�I؉�^��\nr����t$Sf0�!�2z�\Z���0��A_ft9�P��Փ7i��\ZjT�����$�\\ñ^i�$�p��X�b�����O}���/5O�\'��U|�}`��Pbܻ�78�suv��{T���->7:i��(�d�垽�?��\'O`�L�Y�\'��y�4K{yYN)@���䂱u���}l���|�谽\\&��pfkC+�}hM�@J:�7Ҥ@ӵ�y<� r\"�KCtt����y�� ,p���\n\n�8b$Ӷ��R� �z��������0�!)+�꾑p~�Po��- [�-��ԉT�z�x��WaـyX^\rيhI��R�N�	re���ˍ,��\"�����0�U>�Ү�	���I�Ӆ��RY\Z+Xǣ��T�K���lՋY,,�+$�U��Ys�M�!C�i�И��磤a��t)�L���ǰ\nc�HqP��}f��C�\0��D+-T]DQ	�dO@��m1�����W@\\��~�2��`Eղ�Z�n?����jZd��������Gͭ?�Q;`�*���؅�f��������`�Dq$5\'�_X�2�}�bl�ͯ����Lu/���+}� P�k}�v?����A��\0IK�Ů߼�ߟ��$k<pS���\n�Ҡ&ּ�/�yK�ޑ�4���G,x�\"Nz��Y����p�}���Q�o��|���)�	��U�R7\ZXs�Ԝ}������\n��#�`���}�\ZlU�����ni��!�K����aH�6�:�Ӽ�]Y��)_��~h�1�\Z�C�\'�\r�:��oKK�����q#�.%�yǮ�O�$���3��4���� _ݓ>%������g�4�8Ϯ*�h\n������eO��U��̞>ɿ70�� [���,��z��/|t:����G\"�}��D��U[~��|����<Mq�N�|��Q���۷ ����W�����&^A�ľ��\0�k�W\0}#$M��@�r��c@ 7�{Yd��Zl su��U˘K�s�StKP^��s=�݅uꋌW>z6x�	�{�9\\0�/�D-���ڸW@WGhͪ�.��CA\"��^�l����y�qD���`��Rᓦ��\'���!Ƨ���Ћ1*�k:6���F��F�s�%��DC�\"�D��.�G1��S�\Z���Gc���s���WH>Pf���/Ĝq�(і��B���⚧�=4s:+��ݿn3)��3�7�at��*��R���Б��8���q�%~�\nXC`X�&*?-AЯ]�*�\r�&Ih)ΗjN1כ�6��1#ZK\Z�*�Ȫ�/a��`��_@�u�3+��a�#�ߡ�U��ǐ�J<O��c0����=���AٜPb:�*|~*r���Z�G�7�_\Z���oV�,)}�3�\"\Zq�U����to	2_&f�\n׈i���į�������d���Ene��D/m�����pžН7Q޲�=y%�W������@����5Go�E����$�	����o���0,���Brd��G�o^����Go�gl�k��r�.�����ΛY�P}|����p��c����D*Մ��F�-��P�C8�dޱ�\\����;z`��(y�,T��j���gԱD�J�0�a��k�gW����Z9_o�/��eM�P���D�Y�m�$�KMS�ϒC��(��ĺK��AD�ߔX��Џ��	Wu?K&3���,Aj6Hm�Xv�עWt���}pծ����!Y\r���#���`��r��3ɓ�\r��8c����\0��3Λ�����CF˝\0��m��;�>Mp��7���F�Qz\'�u�p�B�1J&}e����\'�mp25��+`!`J(�;�&�ӞG/Lo�.���i���{VɦJN���s��b��Co���a$�0�����&�=u�.f�IP����e�>�����0)$�\0��f7\ZW8���Վ��y�s���)y<����;�h��K�Ԧ�]Lw<���\"�}{����\\�u�!iiM�_�����	�»hK\'��N_F�-E3\'5���!W�>I�C�2��	͓�neqy�\'C���_\\LT��9y8��?2��x-ζ-��Ti�_�S�\\��!�wz�W�H�Ԛ>v��#NNJ����j��.*d��\'5������u���\'yM�)4��.��\nO�[�P�3a��\np)��)(KHc���l���H:V�A,f���v�s/�A�R�1ҏ,����=Ύ�Y\0h,�cZ��j��{6�O�~��Eg���3�0 �0���D_���՟Z���4���J�����{��$J$�����?x�W0U�0���rlZ�~���G�	�+�gRa\\��\"j�~V�Y�����Z������m���\n|w�0QH�:�fMA�&��;r����3���؆^�ߠ��Չo-�=d�D�tYI=R�v��(�;h\"͂�8�\"O��D6��e�=xr\06�/�vXӣ�ؾz:>��Jus	u���m{�F�?Q�@��k���4�Ѵ��9tv�:֪�δ�v�&�aX���Ӕ&�2�-HLݧY��D�݊X̀4aVVG��Z��X�:Mg���I�X��co��B��>��-\Zk.����W�9���>�����+��-�z��_k�|~���;�z��������>���{x�ӌ��w��0���V������y���]-����CbU�C����O��q~s��g�:���0=���v��oRSu�W��-M�c�4�Yw����Y��3d�0E[�\n��<��Sg��q���;��%/�?��X����0��;�ߴ�ն��#!?��G���������������B�K�<]0^]p���y\Z�������\'-f/�֙~=s\'x�2e��������n��[f�6�bo5�~������;�/\'>G1o���)���n�HO�<>�<.��),���&Dn���_.���x⯲��fb��y�����[�|i�qo�~�������n�$�<e�>%�~�\'AH�kύ�/�.�˿�<=�F��w�u�\n�½?#�?��;���U�6���U|��5�6������Cǿ���������\0���T�E������@�K�Db��������o�Bh�������zoui� \0p�_~W��yd���恄�~q�y5����g���;|Hfnq4\"\'���5��C�`^����|�Zp���r-��H++�y��`,%\'zIGG��˘L��#�.)�Z�^�3�o�9�����+��6NỴ�O%I�?��4��\nT�&�T��:e(�H�@�i��<F�Pfۘlݕi8��2 {?��/P�s��b��Z��cC	2���y��1��@H���i��n�����N�}\0�|SL�(u�%�U���Y���4~����:�s=]9��Q�aj:��t4�������?�En��g�Q^|����\n��t�ۿX�F�J�*H8�G�Z��D���L\r�{��B�Tk�|��`@�j����1@1�ןS}̗f\r\rzP;!7I¸���kFB����Jzl��/��9T�Cp,mD<��?�oݤ��F=hXH��5z�g���.HN��Z��Ek��%�ҟ���Bًȥ�;�cp���E�%@O�r2�/�Ш�!��ƲOW\"�L>9�S�o8�,�G?�	�v\r��V+{���;	����������K���]��>[\\�(\Z���v�<������@98_-0�N@�b>�C�����DCi���U \'�݇�.�G��q��kq~C�r�!�/Ł�:��Rͧ��c�7�ǿ|&=JѨ�\0֘)A8���e+�\Z�Z-��FM�nF��R.�b2�)W�W�.��uڷ�?��\'�pf�lӳ`딝�JA���a�Cڊ���Up|i9��Y̳Z�P��^�}�ڤ��>���(�`��Yc�����o�{*�9t�u����B`O�cM�&\047ؗ�x΀�4��;:��]�V���:�M��m�r�J�bxg��]e���>�tcy2�!��6��n�ҹp�H���5VH\n��-�\0.�E���C4��J�<�s�`Y;IR��tg �,��i�fޗ\"�&פ\\\Z�Z6&a})	z8�%AHbx�������|�0�����\0(L.͂�iWn\\�G�Z���z�<�q|�+��Du0��	����߯�,jT�����U����B�iJoV�lk�Y��R$�鱶Ѹk���%�rx���S	�~9�i�9�i��uZ$�C�J�-0~�X�\Z�V����\\@��x��f�S�X��)\0�J`x(�i�����|`Ϡ�KBh����b�\nRH�G�\\�\0kQ��[)�]Z�A��h��l��o�dĵ|z�.8�c�+���O��Me!ke�a2\n�$!����4]ޏ\r�1�$�L�Z$�B\0CXY�wgn��g�hh\"3\"\"�8��a`,�v>�\0���E�����,��ȁ1��68���u��\\�A���-!މ��Q���Gv�0�o����2���Ij�ڪ���D���1֖q���i\r3XHҪzn��3\0\'�t�;Bg@�K�%�|p#���%\'M��:W��թ։t�W%��ٯ�d �\\@O��\n��#�~z��:+v�?�	24ZY�lR�/,f@� �׭?��=	Ț���O�������Qb7Y�����_�BO(A�,�3(GY����$\r�d���C.Hm��>���\n@�7J�R��w�䥢�6	o��˨M�����p�yb&�.Tm�z(�Ft,q>�hj�I��^HHI9qlSK���1d�=���ST)�,+9���a���k=��Nw�DW������Ƀ�9(i@\rs�U-�Z!�j���+@D��1�)P9�]Z��Ê|�>��h��҄?����N\"�T�%,1v$���F�AZ��Z-ɩ����VV��\Z�\ZJ7@4�c)+��`��Z�%��}�q�{��\n$ra\n�m�E��]��j�E��)ugr7!���y ��UQ{K,��G�r¦T��^�\" �d�	=�F��\0+�Sg�Kd�dt��ݓZ�v��<��z�֢xM�Y�#�ca�\'3(���hr[�;L-�w*i�\n��zz�^8�������斜��L�{��/��1,V��G���t�R�輸;��&&t+K�4p4�]�&,1!�I�4��K����r�d �3���XA�Զ4�TC} �� H�i v���#P�{\r��=����Z���%N��=!y�yVi��F�1�&�(Xk\\#��n�C�6�����QC�b4�jfD~K���q�	!�x�5��ML�[,�i\\X�D�;2�R��\n>\"�3�/W�3���������, 0�����2����\"%��[�{(�]@�7մ��9�xba�YryF\r���4~I\0gڱ�0ϴ�L3�|�x�@����� �7�z�ze��6����`j��,\0aa>�g�����#Li�LN@r�07\\)�C��\r�y�1AOQ�X\\����c�9_:���-O���)���b�(<�B�Tt��y���Y<\'��PiǠ�ש��;	��`E[�҅�l*Eʙ!.I6\"TE��sM�1��!����n�^��N%s�����a�5j?r�	�����f����=����Rۧ��E\04R��N��-]W�j�o&y�T�:6w%�W� �H�G/GMF\Z���$�W@�^����O����I0������c�\"0�m	�t��~��u�С�2�Jq�\0e�m��a#�����AMud~��cr��Ĉq�����ʯH]����}��	C��[�x�_���5_P�����d��9ysv(���|��	Sm$��1Ք;�	���`��t�၆6 �\Z?���J�y��\\FqҪk	��о~v��n�k��_\0�1�b�.%O���b�e9����$Ns��{�|q+��$T���+)A%jeͅ�/SA�P�7?�4^�y:��!\n�EJ���u���_Ώ5TKR�R��6��I��iS	k�){;��YaM�y���,�i�E|��E�9y��O\n�� �S���W�h�Xlۦ��g�\0����)l=C���P�D#��īutV�di:m� U��d�����g��E���\0Č������B�k�l�I����W~q�C��ND񹶙v�׹h^��pS���s�\"	����h�G�(��(h��s��b����%xd�׾�n	�s3K��f_�H�胡�Cu%W�1Q�P��O�%�;c���e�Bs�0P��>̟A��q�~����\n+��hmS����$;�y(m.���pQ���Mi����G6�0*`[�a�3\"��+O,�l\n�\r{1F�faO,r�����8�i\n\n\Z��	;!5EX/$܇�]���9)��\0������@�Ql*.)rV*�y�4`�k�i\"���MZ=�Z@ �T����z���Z�u��_#�_&�r���~�w�g��x��f�\0�9$���&o��������^��j ���P��4���s����NH�W��V��ᰄ�9D,���J0��ufD\n�pWR���4�g����]�⧳��+J��=����́�S��5a5��l�ԇ���\n[ML�y[��{⛓�\n^�h)�:1c�O���C��iE{�<VH	��>[A��g���A����!a�\"�Kps?0�U>3Ƒ1���m�[,��`��|aE9��EQD�̩[n�B!�\n�-$�;y6��Mvs%�ł��-5��s��tlA��vf���_�ڨ�W\r�敮^K/x���l���)R`fJωF�F�]�وe�a�S�NX�+�YA�\\�qcD�J��e}7�a[^��5���|�L�&>��ʎ�Fa>\0���\"]�zǏ�,�_�\0_ ����6�Dy�	/��8��8ڕ�C��0���WeL��%;Q�Aok�Y�%9�ʑ�����X@N��D*��j�C�������/B�f��b�<�l�o��B��`�T�²�<^@I�S��ǁ\r�d�xr�z	l�/�**�\0\\Y���4��<��	��oO�	dZ�}�L	�-�+�sal�,j��uq�|{�#���8ܐ	�~\Z+�^R��o��</�o.f-��!��\'72�6�u�0���\'��\"2<����M%:|o�T�6��q�vlD�zؾ0lV�n	e�8�\0�w N����@]����z���[>2g��|���+�g~�DX���$x�늜\"\\%����u�L���0[!4�b!l�6}\n\"t�sk���0�Y>W��\0��uB��Np~����%䗴�]��(�����K�d��QN�B��U��1��Ek�\0����P�F��.�S`���������hK�>Pv?�3_�y���^x@*f� W����A��\0��� 岼�p�=%�ln�rt�1aO�ĥ}�p�6g�9��\'�\\�}aP�%�Y�z�>j�=&w�ڐ$E\0��q. T^��KIl��R���XqP(�.1���~���,+�`�\"�NcU�7h-\r�4�d^���zm\n����+�G���i�Pq#�3O_Hd���עA!?b�&��M8�@C� �\'����J��lm$7��R+�U����T�T~\\�`�e:)qT\"�MMlv)[����⎵WC�f��3\n��M��߁����%`��_[6FS���8˦4\n�,\'R;t�X2�˃/�K���\'�\"a��&�Jޅ�Mb��g&�L������WO���s[^f,����&a�9r�R�(3�<�fn��o��K�\0\"��VpТ�{�����\rZ8W��k�X�I�˝��$?\rK&�R:\r��ŵB��,a�D�p�0�Z�z�ϡ�]�ϓ��^�1��Ʈ����\\L�|��]Ӵ��r!r\\$@�m����NF�+�BL���Z�-f�:�O��	m��p�WH��Ld���\Z�\r�}�����=�x�@Pfrk�.�і�	�h�6��w�q�$�%��0(�C��y��pC�&\\X=S	��v�·ێ��ǎ=����\nRKx�LD~S�Vf�)`�������s�ؙ<�K\Z�VcC�ǂ�\n�G.�ہ�r�WjA��~�@�\ZJ�QO�\Z5N����	;x��T�ļNk�P���7�����h�N:�w��A�\\���\"q$8���Q+j�/\0<MbT8\0��(x�a���E}N�KT%;�I$1��*\\�]�hO_�h�P��F�+`��r{ryT�%���ZK p&�d���(K�c2\"̢!�?�m��U�P�\rF���.��^Ӓ�p�Bpa�м�`J����T�\r��2aR���b�dfu�����[��[��t5��p�Q��f�%�u���ZO��F;���af����\Z�mqp�y�\"��ˋ\rC?���E �F.iÕp��Z���������Ҿ5����>�����ژ*��K��)ykQ%&\r]J��`��fP�p�JI҄4S\n�� �ޜ�Ҹ��(�}�1m��6�?�)\0�����\")��C�\0�C��T\\���eY�܊0l���q��I�%Ԭi���́�Q=�72�MńUU@���d���R���)?	�8�įԢ�x\Zv�u�Ȑ>h�dA��U�B�A%d\"m�r�~Ο��=�}���{��	��ĝ��ý�z%�-A�S��\r�L�h|���)�b{)֘�Ӹ��K;���F�ȃJ2?�pO&�m�J)��Qt���*�S����#t���B1��-\nȓ��(ӿ��P�!��`�ݡҡ��ZY1�G�ڄݱq�+��뿥����>����+x����/����/�^9-�<:���70�x�J�����Vpm�7]�JF듦����K���ѿ_z.Vܵ[�>��Z\rs�s��Z��̧�ׅ�\"}�W','ಸಿಮೆಂಟ್ ಕಾಂಕ್ರೀಟ್ ರಸ್ತೆ ಹಾಕುವುದು',NULL,'ABC','ಎಬಿಸಿ','PL-01',NULL,NULL,'WD-01','ಸಿಮೆಂಟ್ ಕಾಂಕ್ರೀಟ್ ರಸ್ತೆ ಹಾಕುವುದು','I');

/*Table structure for table `ward` */

DROP TABLE IF EXISTS `ward`;

CREATE TABLE `ward` (
  `ward_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `created_by` int(11) NOT NULL,
  `created_date` date NOT NULL,
  `place_code` varchar(255) NOT NULL,
  `updated_by` int(11) DEFAULT NULL,
  `updated_date` date DEFAULT NULL,
  `ward_code` varchar(255) NOT NULL,
  `ward_name` varchar(255) DEFAULT NULL,
  `ward_namek` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ward_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `ward` */

insert  into `ward`(`ward_id`,`created_by`,`created_date`,`place_code`,`updated_by`,`updated_date`,`ward_code`,`ward_name`,`ward_namek`) values 
(1,1,'2023-07-07','PL-01',NULL,NULL,'WD-01','WARD-1','ವಾರ್ಡ್-1'),
(2,1,'2023-07-07','PL-01',NULL,NULL,'WD-02','WARD-2','ವಾರ್ಡ್-2'),
(3,1,'2023-07-07','PL-01',NULL,NULL,'WD-ALL','ALL','ಎಲ್ಲಾ'),
(4,1,'2023-07-07','PL-02',NULL,NULL,'WD-01','WARD-1','ವಾರ್ಡ್-1'),
(5,1,'2023-07-07','PL-02',NULL,NULL,'WD-02','WARD-2','ವಾರ್ಡ್-2'),
(6,1,'2023-07-07','PL-02',NULL,NULL,'WD-ALL','ALL','ಎಲ್ಲಾ'),
(7,1,'2023-07-07','PL-01',NULL,NULL,'WD-19','19','19'),
(8,1,'2023-07-07','PL-03',NULL,NULL,'WD-12','12','12'),
(9,1,'2023-07-07','PL-04',NULL,NULL,'WD-05','05','05'),
(10,1,'2023-07-07','PL-05',NULL,NULL,'WD-05','05','05'),
(11,1,'2023-07-07','PL-06',NULL,NULL,'WD-09','09','09');
(12,1,'2023-07-07','PL-01',NULL,NULL,'WD-08','08','08'),





/*Table structure for table `ward_ward_set` */

DROP TABLE IF EXISTS `ward_ward_set`;

CREATE TABLE `ward_ward_set` (
  `ward_ward_id` bigint(20) NOT NULL,
  `ward_set_ward_id` bigint(20) NOT NULL,
  PRIMARY KEY (`ward_ward_id`,`ward_set_ward_id`),
  UNIQUE KEY `UK_457le1gnnnuep1gu26d5yqn7p` (`ward_set_ward_id`),
  CONSTRAINT `FK62blqnjwoykbouxiiuspfucgh` FOREIGN KEY (`ward_ward_id`) REFERENCES `ward` (`ward_id`),
  CONSTRAINT `FKt3hi2t3wv3b8x8ga1hi660h8g` FOREIGN KEY (`ward_set_ward_id`) REFERENCES `ward` (`ward_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `ward_ward_set` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
