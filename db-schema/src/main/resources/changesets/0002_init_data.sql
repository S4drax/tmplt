INSERT INTO template.dictionary(dictionary_id, code, type, description, create_user, create_date, update_user, update_date)
VALUES (gen_random_uuid(), 'PAINT', 'PRODUCT_TYPE', 'Farby', 'SADRAX', current_timestamp, null, null);
INSERT INTO template.dictionary(dictionary_id, code, type, description, create_user, create_date, update_user, update_date)
VALUES (gen_random_uuid(), 'MINIATURE', 'PRODUCT_TYPE', 'Miniatury', 'SADRAX', current_timestamp, null, null);
INSERT INTO template.dictionary(dictionary_id, code, type, description, create_user, create_date, update_user, update_date)
VALUES (gen_random_uuid(), 'BRUSH', 'PRODUCT_TYPE', 'Pędzelki', 'SADRAX', current_timestamp, null, null);
INSERT INTO template.dictionary(dictionary_id, code, type, description, create_user, create_date, update_user, update_date)
VALUES (gen_random_uuid(), 'SPRAY_PAINT', 'PRODUCT_TYPE', 'Farby w Spraju', 'SADRAX', current_timestamp, null, null);

INSERT INTO template.addresses(address_id, street, house_number, flat_number, zip_code, city, country, create_user, create_date, update_user, update_date)
VALUES (gen_random_uuid(), 'test', 10, 1, '12-345', 'Warszawa', 'Polska', 'SADRAX', current_timestamp, null, null);

INSERT INTO template.producents(producent_id, address_id, name, description, create_user, create_date, update_user, update_date)
VALUES (gen_random_uuid(), (SELECT a.address_id FROM template.addresses a WHERE a.street = 'test'), 'GW', 'GW', 'SADRAX', current_timestamp, null, null);

INSERT INTO template.products(product_id, category_id, producent_id, name, compare_value, description, create_user, create_date, update_user, update_date)
VALUES (gen_random_uuid(), (SELECT d.dictionary_id FROM template.dictionary d WHERE d.code = 'PAINT'), (SELECT p.producent_id FROM template.producents p WHERE p.name = 'GW'), 'Chaos Black', '#FFFFFF', 'Chaos Black Paint', 'SADRAX', current_timestamp, null, null);

INSERT INTO template.availability(availability_id, product_id, stock, price, currency, create_user, create_date, update_user, update_date)
VALUES (gen_random_uuid(), (SELECT pr.product_id FROM template.products pr WHERE pr.name = 'Chaos Black'), 5, 10.02, 'PLM', 'SADRAX', current_timestamp, null, null);