INSERT INTO filter(id, code, created_at, name, width, height, original_vast_tag, whitelist, blacklist, whitelist_flag) VALUES ('00000000-0000-0000-0000-000000000001', 'test-filter-one', '2020-01-01T12:00:00Z', 'Test Filter One', 5, 5, 'Test Vast', '["mail.ru","yandex.ru"]' FORMAT JSON, null, true);
INSERT INTO filter(id, code, created_at, name, width, height, original_vast_tag, whitelist, blacklist, whitelist_flag) VALUES ('00000000-0000-0000-0000-000000000002', 'test-filter-two', '2020-01-01T12:00:00Z', 'Test Filter Two', 5, 5, 'Test Vast', null, '["mail.ru","yandex.ru"]' FORMAT JSON, false);