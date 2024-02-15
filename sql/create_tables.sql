

CREATE TABLE type_training (
    id SERIAL PRIMARY KEY,
    title VARCHAR(50) NOT NULL
);

CREATE TABLE customer (
    id SERIAL PRIMARY KEY,
    name VARCHAR(50)
);

CREATE TABLE training (
    id SERIAL PRIMARY KEY,
    title VARCHAR(50) NOT NULL,
    description_training VARCHAR(1000),
    customer_id INT,
    time INT,
    type_training_id INT,
    body VARCHAR(50),
    FOREIGN KEY (type_training_id) REFERENCES type_training(id),
    FOREIGN KEY (customer_id) REFERENCES customer(id)
);

CREATE TABLE exercise (
    id SERIAL PRIMARY KEY,
    body VARCHAR(50),
    title VARCHAR(50) NOT NULL,
    description_exercise VARCHAR(1000),
    url VARCHAR(1000),
    order_use VARCHAR(1000),
    time INT,
    contradictions VARCHAR(1000)
);


CREATE TABLE training_exercise (
    id SERIAL PRIMARY KEY,
    training_id INT NOT NULL,
    exercise_id INT,
    approach INT,
    priority INT,
    FOREIGN KEY (training_id) REFERENCES training(id),
    FOREIGN KEY (exercise_id) REFERENCES exercise(id)
);

CREATE TABLE muscle (
    id SERIAL PRIMARY KEY,
    title VARCHAR(50) NOT NULL
);

CREATE TABLE exercise_muscle (
    id SERIAL PRIMARY KEY,
    exercise_id INT,
    muscle_id INT,
    FOREIGN KEY (exercise_id) REFERENCES exercise(id),
    FOREIGN KEY (muscle_id) REFERENCES muscle(id)
);

insert into customer (name) values ('Ivan');
insert into customer (name) values ('Vitalii');
insert into customer (name) values ('Dmitrii');


insert into type_training (title) values ('Утренняя зарядка');
insert into type_training (title) values ('Фитнес дома');
insert into type_training (title) values ('Разминка на работе');
insert into type_training (title) values ('Раслабление перед сном');

insert into muscle (title) values ('Мышцы живота');
insert into muscle (title) values ('Икры');
insert into muscle (title) values ('Квадрицепс');
insert into muscle (title) values ('Трицепс');
insert into muscle (title) values ('Бицепс');
insert into muscle (title) values ('Мышцы шеи');


insert into exercise (body, title, description_exercise, url, order_use, time, contradictions) values ('PRESS', 'Скручивания вперёд', 'Описание','https://drive.google.com/file/d/1PZobFaSjYoFLQfbdcEvPCKpo2vbfBVuz/view?usp=drive_link',
                                       'Описание очередности', 40, 'Описание противопоказаний');
insert into exercise (body, title, description_exercise, url, order_use, time, contradictions) values ('BOTTOM', 'Бег на месте', 'Описание', 'https://drive.google.com/file/d/19xNx0XvSpo3efFvxBG6BQPUbgpchfseE/view?usp=drive_link',
                                       'Описание очередности', 40, 'Описание противопоказаний');
insert into exercise (body, title, description_exercise, url, order_use, time, contradictions) values ('UPPER', 'Качаем трицепс', 'Описание', 'https://drive.google.com/file/d/1fHkKfBhgCdalRnfajyfCalMOMzv8OaMJ/view?usp=drive_link', 'описание очередности', 60, 'Описание противопоказаний');
insert into exercise (body, title, description_exercise, url, order_use, time, contradictions) values ('UPPER', 'Качаем бицепс', 'Описание', 'https://drive.google.com/file/d/11wDMqTb4v_ZuN3KIox3oUVlZ2Scd8LKz/view?usp=drive_link',
                                                                                     'Описание очередности', 50, 'Описание противопоказаний');
insert into exercise (body, title, description_exercise, url, order_use, time, contradictions) values ('BOTTOM', 'Растяжка правой икры', 'Описание', 'https://drive.google.com/file/d/14TjxkSEOdsoNZMm22Z8QqL5nlVl2bIqW/view?usp=drive_link',
                                                                                     'Описание очередности', 50, 'Описание противопоказаний');
insert into exercise (body, title, description_exercise, url, order_use, time, contradictions) values ('UPPER', 'Разминка шеи', 'Описание', 'https://drive.google.com/file/d/1CmM46rmAaFjtP1hCTUPjTewRdri6I6sZ/view?usp=drive_link',
                                                                                     'Описание очередности', 40, 'Описание противопоказаний');
insert into exercise (body, title, description_exercise, url, order_use, time, contradictions) values ('BOTTOM', 'Разминка колен', 'Описание', 'https://drive.google.com/file/d/1ASW_JakoVR0cnMA5x_pHxSdZa-2KsZlm/view?usp=drive_link',
                                                                                     'Описание очередности', 40, 'Описание противопоказаний');
insert into exercise (body, title, description_exercise, url, order_use, time, contradictions) values ('PRESS', 'Вело-скручивания', 'Описание', 'https://drive.google.com/file/d/1k8Oa_yQYWdxuoAN6zxp7SOZOW3MF2Fjy/view?usp=drive_link',
                                                                                     'Описание очередности', 50, 'Описание противопоказаний');






insert into exercise (body, title, description_exercise, url, order_use, time, contradictions) values ('BOTTOM', 'Кокон', 'Описание', 'https://drive.google.com/file/d/1zZG8rvU9XnN_F9i8PNpuVYTOqTRL3v--/view?usp=drive_link',
                                                                                 'Описание очередности', 50, 'Описание противопоказаний');
insert into exercise (body, title, description_exercise,url, order_use, time, contradictions) values ('ALLBODY', 'Морская звезда', 'Описание', 'https://drive.google.com/file/d/1DoZZwB61s8cXTRNh6gFe8Un5LaNqu_8P/view?usp=drive_link',
                                                                                 'Описание очередности', 50, 'Описание противопоказаний');
insert into exercise (body, title, description_exercise,url, order_use, time, contradictions) values ('PRESS', 'Скалолаз', 'Описание', 'https://drive.google.com/file/d/1-z9UIyJB_o63fg5M7Jwcgau818BoXj31/view?usp=drive_link',
                                                                                 'Описание очередности', 60, 'Описание противопоказаний');
insert into exercise (body, title, description_exercise,url, order_use, time, contradictions) values ('ALLBODY', 'Бёрпи', 'Описание', 'https://drive.google.com/file/d/1NMMgiQ4bb8RpqF7k32kvikv6rTtTihbU/view?usp=drive_link',
                                                                                 'Описание очередности', 50, 'Описание противопоказаний');
insert into exercise (body, title, description_exercise,url, order_use, time, contradictions) values ('ALLBODY', 'Медведь', 'Описание', 'https://drive.google.com/file/d/1IglVKCGE4x7A-b99gq9thDhQqnkL3k7B/view?usp=drive_link',
                                                                                 'Описание очередности', 40, 'Описание противопоказаний');
insert into exercise (body, title, description_exercise,url, order_use, time, contradictions) values ('BOTTOM', 'Краб', 'Описание', 'https://drive.google.com/file/d/113BhX01FWebSSffdqk8JBNJpVXPGDJ9s/view?usp=drive_link',
                                                                                 'Описание очередности', 40, 'Описание противопоказаний');
insert into exercise (body, title, description_exercise,url, order_use, time, contradictions) values ('UPPER', 'Отжимания с колен', 'Описание', 'https://drive.google.com/file/d/1OxFo63li5FNuqEZYVGPetoiWCmTdfzCv/view?usp=drive_link',
                                                                                 'Описание очередности', 60, 'Описание противопоказаний');
insert into exercise (body, title, description_exercise,url, order_use, time, contradictions) values ('UPPER', 'Динамическая планка', 'Описание', 'https://drive.google.com/file/d/1Zi_kiIPHGYDL3AN_azdpBWJi2B3q5D2_/view?usp=drive_link',
                                                                                 'Описание очередности', 60, 'Описание противопоказаний');






insert into exercise_muscle (exercise_id, muscle_id) values (1, 4);
insert into exercise_muscle (exercise_id, muscle_id) values (2, 2);

insert into exercise_muscle (exercise_id, muscle_id) values (2, 3);

insert into exercise_muscle (exercise_id, muscle_id) values (3, 4);
insert into exercise_muscle (exercise_id, muscle_id) values (4, 5);
insert into exercise_muscle (exercise_id, muscle_id) values (5, 1);
insert into exercise_muscle (exercise_id, muscle_id) values (6, 6);

insert into exercise_muscle (exercise_id, muscle_id) values (7, 3);
insert into exercise_muscle (exercise_id, muscle_id) values (7, 2);

insert into exercise_muscle (exercise_id, muscle_id) values (8, 1);


insert into training (id, title, description_training, customer_id, time, type_training_id, body)
 values (1, 'Мощный пресс', 'Описание тренировки', 1, 60, 2, 'PRESS');
insert into training (id, title, description_training, customer_id, time, type_training_id, body)
values (2, 'Экспресс-фитнес', 'Описание тренировки', 3, 30, 2, 'PRESS');
insert into training (id, title, description_training, customer_id, time, type_training_id, body)
values (3, 'Ноги-молоты', 'Описание тренировки', 2, 50, 1, 'BOTTOM');
insert into training (id, title, description_training, customer_id, time, type_training_id, body)
values (4, 'Взбодрись', 'Описание тренировки', 1, 40, 1, 'ALLBODY');


insert into training_exercise (training_id, exercise_id, approach, priority) values (1, 1, 4, 1);

insert into training_exercise (training_id, exercise_id, approach, priority) values (2, 2, 3, 1);

insert into training_exercise (training_id, exercise_id, approach, priority) values (3, 3, 5, 1);
insert into training_exercise (training_id, exercise_id, approach, priority) values (3, 4, 4, 2);

insert into training_exercise (training_id, exercise_id, approach, priority) values (4, 6, 3, 2);
insert into training_exercise (training_id, exercise_id, approach, priority) values (4, 7, 3, 1);
insert into training_exercise (training_id, exercise_id, approach, priority) values (4, 8, 2, 3);












































