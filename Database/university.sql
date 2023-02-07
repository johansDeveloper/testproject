INSERT INTO `grouptable` (`groupId`, `faculty`, `groupNumber`) VALUES
(1, 'INPE', 'B17-101'),
(2, 'INPE', 'B18-101'),
(3, 'IEPB', 'B17-201'),
(4, 'IEPB', 'B18-201'),
(5, 'ILPT', 'S17-302'),
(6, 'ILPT', 'S18-302'),
(7, 'ICIS', 'B17-502'),
(8, 'ICIS', 'B18-502'),
(9, 'INESP', 'B17-402'),
(10, 'INESP', 'B18-402'),
(11, 'INESP', 'B18-403');
COMMIT;

INSERT INTO `student` (`studentId`, `groupId`, `studentName`, `scholarship`, `dateOfEnrollment`) VALUES
(1, 1, 'Alex', 'usual', 'Fri Sep 01 2017'),
(2, 2, 'Dolly', 'usual', 'Sat Sep 01 2018'),
(3, 3, 'Rick', 'increased', 'Fri Sep 01 2017');
COMMIT;