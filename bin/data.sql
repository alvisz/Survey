CREATE TABLE SECTORS(
    SECTOR_ID BIGINT NOT NULL PRIMARY KEY,
    PARENT BIGINT,
    NAME VARCHAR(64) NOT NULL
);

CREATE TABLE RESULTS(
    RESULT_ID BIGINT AUTO_INCREMENT PRIMARY KEY,
    NAME VARCHAR(64) NOT NULL,
    SECTORS INTEGER ARRAY[5] NOT NULL
);

INSERT INTO SECTORS (SECTOR_ID, NAME) VALUES (1, 'Manufacturing');
INSERT INTO SECTORS (SECTOR_ID, PARENT, NAME) VALUES (19, 1, 'Construction and materials');
INSERT INTO SECTORS (SECTOR_ID, PARENT, NAME) VALUES (18, 1, 'Electronics and Optics');
INSERT INTO SECTORS (SECTOR_ID, PARENT, NAME) VALUES (6, 1, 'Food and Beverage');
INSERT INTO SECTORS (SECTOR_ID, PARENT, NAME) VALUES (342, 6, 'Bakery & confectionery products');
INSERT INTO SECTORS (SECTOR_ID, PARENT, NAME) VALUES (43, 6, 'Beverages');
INSERT INTO SECTORS (SECTOR_ID, PARENT, NAME) VALUES (42, 6, 'Fish & fish products');
INSERT INTO SECTORS (SECTOR_ID, PARENT, NAME) VALUES (40, 6, 'Meat & meat products');
INSERT INTO SECTORS (SECTOR_ID, PARENT, NAME) VALUES (39, 6, 'Milk & dairy products');
INSERT INTO SECTORS (SECTOR_ID, PARENT, NAME) VALUES (437, 6, 'Other');
INSERT INTO SECTORS (SECTOR_ID, PARENT, NAME) VALUES (378, 6, 'Sweets & snack food');
INSERT INTO SECTORS (SECTOR_ID, PARENT, NAME) VALUES (13, 1, 'Furniture');
INSERT INTO SECTORS (SECTOR_ID, PARENT, NAME) VALUES (389, 13, 'Bathroom/sauna');
INSERT INTO SECTORS (SECTOR_ID, PARENT, NAME) VALUES (385, 13, 'Bedroom');
INSERT INTO SECTORS (SECTOR_ID, PARENT, NAME) VALUES (390, 13, 'Children’s room');
INSERT INTO SECTORS (SECTOR_ID, PARENT, NAME) VALUES (98, 13, 'Kitchen');
INSERT INTO SECTORS (SECTOR_ID, PARENT, NAME) VALUES (101, 13, 'Living room');
INSERT INTO SECTORS (SECTOR_ID, PARENT, NAME) VALUES (392, 13, 'Office');
INSERT INTO SECTORS (SECTOR_ID, PARENT, NAME) VALUES (394, 13, 'Other (Furniture)');
INSERT INTO SECTORS (SECTOR_ID, PARENT, NAME) VALUES (341, 13, 'Outdoor');
INSERT INTO SECTORS (SECTOR_ID, PARENT, NAME) VALUES (99, 13, 'Project furniture');
INSERT INTO SECTORS (SECTOR_ID, PARENT, NAME) VALUES (12, 1, 'Machinery');
INSERT INTO SECTORS (SECTOR_ID, PARENT, NAME) VALUES (94, 12, 'Machinery components');
INSERT INTO SECTORS (SECTOR_ID, PARENT, NAME) VALUES (91, 12, 'Machinery equipment/tools');
INSERT INTO SECTORS (SECTOR_ID, PARENT, NAME) VALUES (224, 12, 'Manufacture of machinery');
INSERT INTO SECTORS (SECTOR_ID, PARENT, NAME) VALUES (97, 12, 'Maritime');
INSERT INTO SECTORS (SECTOR_ID, PARENT, NAME) VALUES (271, 97, 'Aluminium and steel workboats');
INSERT INTO SECTORS (SECTOR_ID, PARENT, NAME) VALUES (269, 97, 'Boat/Yacht building');
INSERT INTO SECTORS (SECTOR_ID, PARENT, NAME) VALUES (230, 97, 'Ship repair and conversion');
INSERT INTO SECTORS (SECTOR_ID, PARENT, NAME) VALUES (93, 12, 'Metal structures');
INSERT INTO SECTORS (SECTOR_ID, PARENT, NAME) VALUES (508, 12, 'Other');
INSERT INTO SECTORS (SECTOR_ID, PARENT, NAME) VALUES (227, 12, 'Repair and maintenance service');
INSERT INTO SECTORS (SECTOR_ID, PARENT, NAME) VALUES (11, 1, 'Metalworking');
INSERT INTO SECTORS (SECTOR_ID, PARENT, NAME) VALUES (67, 11, 'Construction of metal structures');
INSERT INTO SECTORS (SECTOR_ID, PARENT, NAME) VALUES (263, 11, 'Houses and buildings');
INSERT INTO SECTORS (SECTOR_ID, PARENT, NAME) VALUES (267, 11, 'Metal products');
INSERT INTO SECTORS (SECTOR_ID, PARENT, NAME) VALUES (542, 11, 'Metal works');
INSERT INTO SECTORS (SECTOR_ID, PARENT, NAME) VALUES (75, 542, 'CNC-machining');
INSERT INTO SECTORS (SECTOR_ID, PARENT, NAME) VALUES (62, 542, 'Forgings, Fasteners');
INSERT INTO SECTORS (SECTOR_ID, PARENT, NAME) VALUES (69, 542, 'Gas, Plasma, Laser cutting');
INSERT INTO SECTORS (SECTOR_ID, PARENT, NAME) VALUES (66, 542, 'MIG, TIG, Aluminum welding');
INSERT INTO SECTORS (SECTOR_ID, PARENT, NAME) VALUES (9, 1, 'Plastic and Rubber');
INSERT INTO SECTORS (SECTOR_ID, PARENT, NAME) VALUES (54, 9, 'Packaging');
INSERT INTO SECTORS (SECTOR_ID, PARENT, NAME) VALUES (556, 9, 'Plastic goods');
INSERT INTO SECTORS (SECTOR_ID, PARENT, NAME) VALUES (559, 9, 'Plastic processing technology');
INSERT INTO SECTORS (SECTOR_ID, PARENT, NAME) VALUES (55, 559, 'Blowing');
INSERT INTO SECTORS (SECTOR_ID, PARENT, NAME) VALUES (57, 559, 'Moulding');
INSERT INTO SECTORS (SECTOR_ID, PARENT, NAME) VALUES (53, 559, 'Plastics welding and processing');
INSERT INTO SECTORS (SECTOR_ID, PARENT, NAME) VALUES (560, 9, 'Plastic profiles');
INSERT INTO SECTORS (SECTOR_ID, PARENT, NAME) VALUES (5, 1, 'Printing');
INSERT INTO SECTORS (SECTOR_ID, PARENT, NAME) VALUES (148, 5, 'Advertising');
INSERT INTO SECTORS (SECTOR_ID, PARENT, NAME) VALUES (150, 5, 'Book/Periodicals printing');
INSERT INTO SECTORS (SECTOR_ID, PARENT, NAME) VALUES (145, 5, 'Labelling and packaging printing');
INSERT INTO SECTORS (SECTOR_ID, PARENT, NAME) VALUES (7, 1, 'Textile and Clothing');
INSERT INTO SECTORS (SECTOR_ID, PARENT, NAME) VALUES (44, 7, 'Clothing');
INSERT INTO SECTORS (SECTOR_ID, PARENT, NAME) VALUES (45, 7, 'Textile');
INSERT INTO SECTORS (SECTOR_ID, PARENT, NAME) VALUES (8, 1, 'Wood');
INSERT INTO SECTORS (SECTOR_ID, PARENT, NAME) VALUES (337, 8, 'Other (Wood)');
INSERT INTO SECTORS (SECTOR_ID, PARENT, NAME) VALUES (51, 8, 'Wooden building materials');
INSERT INTO SECTORS (SECTOR_ID, PARENT, NAME) VALUES (47, 8, 'Wooden houses');
INSERT INTO SECTORS (SECTOR_ID, NAME) VALUES (3, 'Other');
INSERT INTO SECTORS (SECTOR_ID, PARENT, NAME) VALUES (37, 3, 'Creative industries');
INSERT INTO SECTORS (SECTOR_ID, PARENT, NAME) VALUES (29, 3, 'Energy technology');
INSERT INTO SECTORS (SECTOR_ID, PARENT, NAME) VALUES (33, 3, 'Environment');
INSERT INTO SECTORS (SECTOR_ID, NAME) VALUES (2, 'Service');
INSERT INTO SECTORS (SECTOR_ID, PARENT, NAME) VALUES (25, 2, 'Business services');
INSERT INTO SECTORS (SECTOR_ID, PARENT, NAME) VALUES (35, 2, 'Engineering');
INSERT INTO SECTORS (SECTOR_ID, PARENT, NAME) VALUES (28, 2, 'Information Technology and Telecommunications');
INSERT INTO SECTORS (SECTOR_ID, PARENT, NAME) VALUES (581, 28, 'Data processing, Web portals, E-marketing');
INSERT INTO SECTORS (SECTOR_ID, PARENT, NAME) VALUES (576, 28, 'Programming, Consultancy');
INSERT INTO SECTORS (SECTOR_ID, PARENT, NAME) VALUES (121, 28, 'Software, Hardware');
INSERT INTO SECTORS (SECTOR_ID, PARENT, NAME) VALUES (122, 28, 'Telecommunications');
INSERT INTO SECTORS (SECTOR_ID, PARENT, NAME) VALUES (22, 2, 'Tourism');
INSERT INTO SECTORS (SECTOR_ID, PARENT, NAME) VALUES (141, 2, 'Translation services');
INSERT INTO SECTORS (SECTOR_ID, PARENT, NAME) VALUES (21, 2, 'Transport and Logistics');
INSERT INTO SECTORS (SECTOR_ID, PARENT, NAME) VALUES (111, 21, 'Air');
INSERT INTO SECTORS (SECTOR_ID, PARENT, NAME) VALUES (114, 21, 'Rail');
INSERT INTO SECTORS (SECTOR_ID, PARENT, NAME) VALUES (112, 21, 'Road');
INSERT INTO SECTORS (SECTOR_ID, PARENT, NAME) VALUES (113, 21, 'Water');