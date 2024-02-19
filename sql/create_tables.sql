
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

INSERT INTO exercise (body, title, description_exercise, url, order_use, time, contradictions) VALUES
('PRESS', 'Скручивания вперёд', '«Лягте на спину, согните колени и поставьте ступни на землю».&
«Положите руки за голову локтями наружу».&
«Включив пресс, медленно поднимите верхнюю часть тела от земли, наклоняясь вперед, пока туловище не окажется под углом 45 градусов».&
«Задержитесь на мгновение в верхней точке, затем медленно опустите верхнюю часть тела обратно в исходное положение».&
«Повторить желаемое количество повторений».',
 'https://drive.google.com/file/d/1PZobFaSjYoFLQfbdcEvPCKpo2vbfBVuz/view?usp=drive_link',
 'Описание очередности', 40, 'Описание противопоказаний');

INSERT INTO exercise (body, title, description_exercise, url, order_use, time, contradictions) VALUES
('BOTTOM', 'Бег на месте', '«Встаньте, ноги на ширине плеч, руки по бокам».&
«Начните с быстрого перемещения ногами вверх и вниз, как будто вы бежите на месте».&
«Двигайтесь быстро и легко, сосредоточьтесь на том, чтобы оставаться на подушечках ног».&
«Продолжайте желаемую продолжительность или количество повторений».',
 'https://drive.google.com/file/d/19xNx0XvSpo3efFvxBG6BQPUbgpchfseE/view?usp=drive_link',
 'Описание очередности', 40, 'Описание противопоказаний');

INSERT INTO exercise (body, title, description_exercise, url, order_use, time, contradictions) VALUES
('UPPER', 'Качаем трицепс', '«Начните с позиции для отжиманий, положив руки прямо под плечи, а тело образуя прямую линию».&
«Опустите тело вниз к земле, согнув локти и держа их близко к бокам».&
«Как только ваши локти окажутся под углом 90 градусов, опустите предплечья на землю, держа локти прямо под плечами».&
«Сделайте паузу на мгновение, затем надавите ладонями, чтобы поднять предплечья обратно в исходное положение».&
«Повторить желаемое количество повторений».',
 'https://drive.google.com/file/d/1fHkKfBhgCdalRnfajyfCalMOMzv8OaMJ/view?usp=drive_link', 'описание очередности', 60, 'Описание противопоказаний');

INSERT INTO exercise (body, title, description_exercise, url, order_use, time, contradictions) VALUES
('UPPER', 'Качаем бицепс', 'Сядьте на скамейку, раздвинув ноги и поставив ступни на землю.&
Держите гантель в одной руке и поместите локоть на внутреннюю часть бедра, чуть выше колена.&
Поставив ладонь вверх, поднимите гантель к плечу, сохраняя плечо неподвижным.&
Напрягите бицепс в верхней точке движения, затем медленно опустите гантель обратно в исходное положение.&
Повторите желаемое количество повторений, затем поменяйте руки.',
 'https://drive.google.com/file/d/11wDMqTb4v_ZuN3KIox3oUVlZ2Scd8LKz/view?usp=drive_link',
 'Описание очередности', 50, 'Описание противопоказаний');

INSERT INTO exercise (body, title, description_exercise, url, order_use, time, contradictions) VALUES
('BOTTOM', 'Растяжка правой икры', 'Встаньте лицом к стене, поставив ноги на ширине плеч.&
Положите руки на стену на уровне плеч.&
Отступите одной ногой назад, удерживая пятку на земле, а ногу прямо.&
Слегка согните переднее колено и наклонитесь вперед, чувствуя растяжение в икрах.&
Держать растяжку 20-30 секунд.&
Поменяйте ноги и повторите растяжку.', 'https://drive.google.com/file/d/14TjxkSEOdsoNZMm22Z8QqL5nlVl2bIqW/view?usp=drive_link',
 'Описание очередности', 50, 'Описание противопоказаний');

INSERT INTO exercise (body, title, description_exercise, url, order_use, time, contradictions) VALUES
('UPPER', 'Разминка шеи', 'Встаньте или сядьте прямо, расслабив плечи.&
Наклоните голову в сторону, приближая ухо к плечу.&
Держать растяжку 15-30 секунд.&
Повторите с другой стороны.&
Выполняйте по 2–4 подхода на каждую сторону.', 'https://drive.google.com/file/d/1CmM46rmAaFjtP1hCTUPjTewRdri6I6sZ/view?usp=drive_link',
 'Описание очередности', 40, 'Описание противопоказаний');

INSERT INTO exercise (body, title, description_exercise, url, order_use, time, contradictions) VALUES
('UPPER', 'Качаем бицепс', 'Сядьте на скамейку, раздвинув ноги и поставив ступни на землю.&
Держите гантель в одной руке и поместите локоть на внутреннюю часть бедра, чуть выше колена.&
Поставив ладонь вверх, поднимите гантель к плечу, сохраняя плечо неподвижным.&
Напрягите бицепс в верхней точке движения, затем медленно опустите гантель обратно в исходное положение.&
Повторите желаемое количество повторений, затем поменяйте руки',
 'https://drive.google.com/file/d/11wDMqTb4v_ZuN3KIox3oUVlZ2Scd8LKz/view?usp=drive_link',
 'Описание очередности', 50, 'Описание противопоказаний');

INSERT INTO exercise (body, title, description_exercise, url, order_use, time, contradictions) VALUES
('BOTTOM', 'Растяжка правой икры', 'Встаньте лицом к стене, поставив ноги на ширине плеч.&
Положите руки на стену на уровне плеч.&
Отступите одной ногой назад, удерживая пятку на земле, а ногу прямо.&
Слегка согните переднее колено и наклонитесь вперед, чувствуя растяжение в икрах.&
Держать растяжку 20-30 секунд.&
Поменяйте ноги и повторите растяжку',
 'https://drive.google.com/file/d/14TjxkSEOdsoNZMm22Z8QqL5nlVl2bIqW/view?usp=drive_link',
 'Описание очередности', 50, 'Описание противопоказаний');

INSERT INTO exercise (body, title, description_exercise, url, order_use, time, contradictions) VALUES
('UPPER', 'Разминка шеи', 'Встаньте или сядьте прямо, расслабив плечи.&
Наклоните голову в сторону, приближая ухо к плечу.&
Держать растяжку 15-30 секунд.&
Повторите с другой стороны.&
Выполняйте по 2–4 подхода на каждую сторону',
 'https://drive.google.com/file/d/1CmM46rmAaFjtP1hCTUPjTewRdri6I6sZ/view?usp=drive_link',
 'Описание очередности', 40, 'Описание противопоказаний');

insert into exercise (body, title, description_exercise, url, order_use, time, contradictions) values ('BOTTOM', 'Разминка колен', 'Встаньте, ноги на ширине плеч, руки на бедрах.&
Слегка согните колени и оторвите пятки от земли, балансируя на подушечках стоп.&
Держа колени согнутыми, вращайте коленями круговыми движениями сначала по часовой стрелке, а затем против часовой стрелки.&
Выполните движение нужное количество повторений.', 'https://drive.google.com/file/d/1ASW_JakoVR0cnMA5x_pHxSdZa-2KsZlm/view?usp=drive_link',
                                                                                                       'Описание очередности', 40, 'Описание противопоказаний');

insert into exercise (body, title, description_exercise, url, order_use, time, contradictions) values ('BOTTOM', 'Разминка колен', 'Встаньте, ноги на ширине плеч, руки на бедрах.&
Слегка согните колени и оторвите пятки от земли, балансируя на подушечках стоп.&
Держа колени согнутыми, вращайте коленями круговыми движениями сначала по часовой стрелке, а затем против часовой стрелки.&
Выполните движение нужное количество повторений.', 'https://drive.google.com/file/d/1ASW_JakoVR0cnMA5x_pHxSdZa-2KsZlm/view?usp=drive_link',
                                                                                                       'Описание очередности', 40, 'Описание противопоказаний');

insert into exercise (body, title, description_exercise, url, order_use, time, contradictions) values ('PRESS', 'Вело-скручивания', 'Лягте на спину, заложив руки за голову.&
Поднимите ноги от земли и согните колени под углом 90 градусов.&
Поднесите правый локоть к левому колену, одновременно выпрямляя правую ногу.&
Вернитесь в исходное положение и повторите движение в противоположную сторону, приближая левый локоть к правому колену и выпрямляя левую ногу.&
Продолжайте чередовать стороны, вращая педали, необходимое количество повторений.', 'https://drive.google.com/file/d/1k8Oa_yQYWdxuoAN6zxp7SOZOW3MF2Fjy/view?usp=drive_link',
                                                                                                       'Описание очередности', 50, 'Описание противопоказаний');


insert into exercise (body, title, description_exercise, url, order_use, time, contradictions) values ('BOTTOM', 'Кокон', 'Лягте на спину, согните колени и поставьте ступни на землю.&
Положите руки за голову локтями наружу.&
Включив пресс, медленно поднимите верхнюю часть тела от земли, наклоняясь вперед, пока туловище не окажется под углом 45 градусов.&
Задержитесь на мгновение в верхней точке, затем медленно опустите верхнюю часть тела обратно в исходное положение.&
Повторить желаемое количество повторений.', 'https://drive.google.com/file/d/1zZG8rvU9XnN_F9i8PNpuVYTOqTRL3v--/view?usp=drive_link',
                                                                                                       'Описание очередности', 50, 'Описание противопоказаний');

insert into exercise (body, title, description_exercise,url, order_use, time, contradictions) values ('ALLBODY', 'Морская звезда', 'Встаньте, ноги на ширине плеч.&
Согните колени и опустите тело в присед.&
Резко прыгните вверх, вытягивая ноги и руки.&
Находясь в воздухе, разведите ноги в стороны и разведите руки в стороны.&
Мягко приземлитесь, поставив ноги на ширине плеч и согнув колени, чтобы поглотить удар.&
Повторить желаемое количество повторений.', 'https://drive.google.com/file/d/1DoZZwB61s8cXTRNh6gFe8Un5LaNqu_8P/view?usp=drive_link',
                                                                                                      'Описание очередности', 50, 'Описание противопоказаний');

INSERT INTO exercise (body, title, description_exercise, url, order_use, time, contradictions) VALUES
('PRESS', 'Скалолаз', 'Начните с положения высокой планки, положив руки прямо под плечи, а тело образуя прямую линию.&
Напрягите корпус и поднимите правую ногу от земли, поднеся правое колено к левому локтю.&
Верните правую ногу в исходное положение и повторите движение левой ногой к правому локтю.&
Продолжайте менять стороны, двигаясь в контролируемом темпе.&
Держите бедра ровно, не поднимайте бедра слишком высоко и не опускайте их слишком низко.&
Сохраняйте ровное дыхание на протяжении всего упражнения.&
Повторить желаемое количество повторений.',
 'https://drive.google.com/file/d/1-z9UIyJB_o63fg5M7Jwcgau818BoXj31/view?usp=drive_link', 'Описание очередности', 60, 'Описание противопоказаний');

INSERT INTO exercise (body, title, description_exercise, url, order_use, time, contradictions) VALUES
('ALLBODY', 'Бёрпи', 'Начните с положения стоя, ноги на ширине плеч.&
Опустите тело в присед, согнув колени и положив руки на пол перед собой.&
Верните ноги в положение для отжимания.&
Выполните отжимание, держа тело прямой.&
Прыжок ногами обратно в положение приседа.&
Резко подпрыгните, вытянув руки над головой.&
Мягко приземлитесь и сразу же опуститесь в присед, чтобы начать следующее повторение.',
 'https://drive.google.com/file/d/1NMMgiQ4bb8RpqF7k32kvikv6rTtTihbU/view?usp=drive_link', 'Описание очередности', 50, 'Описание противопоказаний');


INSERT INTO exercise (body, title, description_exercise, url, order_use, time, contradictions) VALUES
('ALLBODY', 'Медведь', 'Встаньте на четвереньки, положив руки прямо под плечи и колени прямо под бедрами.&
Слегка поднимите колени от земли, сохраняя спину ровной и напряженным корпус.&
Одновременно переместите вперед правую руку и левую ногу, а затем левую руку и правую ногу.&
Продолжайте ползти вперед, чередуя движения рук и ног.&
Сохраняйте устойчивый темп и напрягайте корпус на протяжении всего упражнения.&
Продолжайте желаемое расстояние или время.',
 'https://drive.google.com/file/d/1IglVKCGE4x7A-b99gq9thDhQqnkL3k7B/view?usp=drive_link', 'Описание очередности', 40, 'Описание противопоказаний');

INSERT INTO exercise (body, title, description_exercise, url, order_use, time, contradictions) VALUES
('BOTTOM', 'Краб', 'Начните с того, что сядьте на землю, согнув колени и поставив ступни на пол.&
Положите руки позади себя, пальцами к ногам, и поднимите бедра от земли.&
Вытяните одну ногу прямо перед собой, одновременно протягивая противоположную руку к пальцам ног.&
Вернитесь в исходное положение и повторите в другую сторону.&
Продолжайте чередовать стороны желаемое количество повторений.',
 'https://drive.google.com/file/d/113BhX01FWebSSffdqk8JBNJpVXPGDJ9s/view?usp=drive_link', 'Описание очередности', 40, 'Описание противопоказаний');

INSERT INTO exercise (body, title, description_exercise, url, order_use, time, contradictions) VALUES
('UPPER', 'Отжимания с колен', 'Встаньте на колени, расставив колени на ширине плеч.&
Положите руки на землю перед собой на ширине плеч, пальцы направлены вперед.&
Вытяните ноги прямо позади себя, балансируя на носках и руках, образуя прямую линию от головы до пяток.&
Согните локти и опустите верхнюю часть тела к земле, держа локти близко к бокам.&
Задержитесь на мгновение внизу, затем подтолкните руки, чтобы выпрямить их и вернуться в исходное положение.&
Повторить желаемое количество повторений.',
 'https://drive.google.com/file/d/1OxFo63li5FNuqEZYVGPetoiWCmTdfzCv/view?usp=drive_link', 'Описание очередности', 60, 'Описание противопоказаний');

INSERT INTO exercise (body, title, description_exercise, url, order_use, time, contradictions) VALUES
('UPPER', 'Динамическая планка', 'Начните с высокой планки, положив руки прямо под плечи, а тело образуя прямую линию от головы до пят.&
Задействуйте корпус и ягодицы, чтобы сохранить устойчивое положение.&
Поверните туловище вправо, поднимите правую руку и вытяните ее к потолку.&
Держите бедра и ноги устойчиво во время поворотов.&
Задержитесь на мгновение, затем вернитесь в исходное положение.&
Повторите поворот с левой стороны.&
Продолжайте чередовать стороны желаемое количество повторений.',
 'https://drive.google.com/file/d/1Zi_kiIPHGYDL3AN_azdpBWJi2B3q5D2_/view?usp=drive_link', 'Описание очередности', 60, 'Описание противопоказаний');

INSERT INTO exercise (body, title, description_exercise, url, order_use, time, contradictions) VALUES
('PRESS', 'Скручивания к пятке', 'Лягте на спину, согните колени и поставьте ступни на землю.&
Вытяните руки в стороны параллельно земле.&
Напрягая пресс, поднимите плечи от земли и протяните правую руку к правой пятке.&
Вернитесь в исходное положение и повторите то же самое с левой стороны, дотягиваясь левой рукой до левой пятки.&
Продолжайте чередовать стороны желаемое количество повторений.',
 'https://drive.google.com/file/d/101Q3Qtb6axdxWH9sc9GzizYbTH2XsIC9/view?usp=drive_link', 'Описание очередности', 40, 'Описание противопоказаний');

INSERT INTO exercise (body, title, description_exercise, url, order_use, time, contradictions) VALUES
('PRESS', 'Планка-гора', 'Лягте на спину, согните колени и поставьте ступни на землю.&
Положите руки по бокам ладонями вниз.&
Напрягая пресс, оторвите ноги от земли, подтянув колени к груди.&
В верхней точке движения напрягите пресс и сделайте паузу на мгновение.&
Медленно опустите ноги обратно в исходное положение.&
Повторить желаемое количество повторений.', 'https://drive.google.com/file/d/1-TQ9nr9bj4fxCOTf71hSpkQ8WR4MGasY/view?usp=drive_link',
 'Описание очередности', 50, 'Описание противопоказаний');

INSERT INTO exercise (body, title, description_exercise, url, order_use, time, contradictions) VALUES
('UPPER', 'Обратные отжимания', 'Начните с высокой планки, положив руки прямо под плечи, а тело образуя прямую линию от головы до пят.&
Задействуйте корпус и ягодицы, чтобы сохранить устойчивое положение.&
Поверните туловище вправо, поднимите правую руку и вытяните ее к потолку.&
Держите бедра и ноги устойчиво во время поворотов.&
Задержитесь на мгновение, затем вернитесь в исходное положение.&
Повторите поворот с левой стороны.&
Продолжайте чередовать стороны желаемое количество повторений.', 'https://drive.google.com/file/d/1g2rQelcnmtgcTNeYYyirQaj0ry-sWeTl/view?usp=drive_link',
 'Описание очередности', 60, 'Описание противопоказаний');

INSERT INTO exercise (body, title, description_exercise, url, order_use, time, contradictions) VALUES
('UPPER', 'Лучник', 'Сядьте на скамейку, раздвинув ноги и поставив ступни на землю.&
Держите гантель в одной руке и поместите локоть на внутреннюю часть бедра, чуть выше колена.&
Поставив ладонь вверх, поднимите гантель к плечу, сохраняя плечо неподвижным.&
Напрягите бицепс в верхней точке движения, затем медленно опустите гантель обратно в исходное положение.&
Повторите желаемое количество повторений, затем поменяйте руки.', 'https://drive.google.com/file/d/11wDMqTb4v_ZuN3KIox3oUVlZ2Scd8LKz/view?usp=drive_link',
 'Описание очередности', 50, 'Описание противопоказаний');

INSERT INTO exercise (body, title, description_exercise, url, order_use, time, contradictions) VALUES
('BOTTOM', 'Сгибание коленей', 'Встаньте, ноги на ширине плеч.&
Согните колени и опустите тело вниз, как будто вы сидите на стуле.&
Держи грудь поднятой, а вес тела переноси на пятки.&
Задержитесь на мгновение внизу, затем оттолкнитесь пятками, чтобы вернуться в исходное положение.&
Повторить желаемое количество повторений.', 'https://drive.google.com/file/d/16bZQaTBoBrU_pwJ-CkhuJYf_Ho988oZx/view?usp=drive_link',
 'Описание очередности', 40, 'Описание противопоказаний');

INSERT INTO exercise (body, title, description_exercise, url, order_use, time, contradictions) VALUES
('BOTTOM', 'Правое колено к стене', 'Встаньте лицом к стене, поставив ноги на ширине плеч.&
Для поддержки положите руки на стену.&
Напрягите корпус и поднимите правое колено к груди, удерживая левую ногу на земле.&
Быстро поменяйте ноги, поднеся левое колено к груди и опустив правую ногу обратно вниз.&
Продолжайте бегом чередовать ноги, поднимая колени как можно выше.&
Поддерживайте быстрый темп и сохраняйте устойчивость верхней части тела на протяжении всего упражнения.&
Повторяйте желаемую продолжительность или количество повторений.',
 'https://drive.google.com/file/d/16bZQaTBoBrU_pwJ-CkhuJYf_Ho988oZx/view?usp=drive_link',
 'Описание очередности', 50, 'Описание противопоказаний');

INSERT INTO exercise (body, title, description_exercise, url, order_use, time, contradictions) VALUES
('BOTTOM', 'Левое колено к стене', 'Встаньте, расставив ноги на ширине плеч, и положите руки на стену или прочный предмет для равновесия.&
Поднимите одну ногу от земли и балансируйте на другой ноге.&
Медленно поднимите пятку от земли, поднимая тело на подушечки стопы.&
Задержитесь на мгновение в верхней точке, затем медленно опустите пятку обратно в исходное положение.&
Повторите необходимое количество повторений, затем поменяйте ногу и повторите.',
 'https://drive.google.com/file/d/16bZQaTBoBrU_pwJ-CkhuJYf_Ho988oZx/view?usp=drive_link',
 'Описание очередности', 50, 'Описание противопоказаний');

INSERT INTO exercise (body, title, description_exercise, url, order_use, time, contradictions) VALUES
('BOTTOM', 'Пятки вверх', 'Встаньте, ноги на ширине плеч, носки направлены вперед.&
Держитесь руками за стену или устойчивую поверхность для равновесия.&
Медленно поднимите пятки от земли, перенеся вес тела на подушечки стоп.&
Задержитесь на мгновение в верхней точке, затем медленно опустите пятки обратно в исходное положение.&
Повторить желаемое количество повторений.',
 'https://drive.google.com/file/d/1WsY-JqsoJfw9LFYoyFzbten29HOJ6n9e/view?usp=drive_link',
 'Описание очередности', 50, 'Описание противопоказаний');

INSERT INTO exercise (body, title, description_exercise, url, order_use, time, contradictions) VALUES
('BOTTOM', 'Журавль на правой ноге', 'Встаньте, расставив ноги на ширине плеч, и положите руки на стену или прочный предмет для равновесия.&
Поднимите одну ногу от земли и балансируйте на другой ноге.&
Медленно поднимите пятку от земли, поднимая тело на подушечки стопы.&
Задержитесь на мгновение в верхней точке, затем медленно опустите пятку обратно в исходное положение.&
Повторите необходимое количество повторений, затем поменяйте ногу и повторите.',
 'https://drive.google.com/file/d/1ZK7bngkLQkTjYluLDk2KoODWdjDE8f0v/view?usp=drive_link',
 'Описание очередности', 40, 'Описание противопоказаний');

INSERT INTO exercise (body, title, description_exercise, url, order_use, time, contradictions) VALUES
('BOTTOM', 'Журавль на левой ноге', 'Встаньте, расставив ноги на ширине плеч, и положите руки на стену или прочный предмет для равновесия.&
Поднимите одну ногу от земли и балансируйте на другой ноге.&
Медленно поднимите пятку от земли, поднимая тело на подушечки стопы.&
Задержитесь на мгновение в верхней точке, затем медленно опустите пятку обратно в исходное положение.&
Повторите необходимое количество повторений, затем поменяйте ногу и повторите.',
 'https://drive.google.com/file/d/1ZK7bngkLQkTjYluLDk2KoODWdjDE8f0v/view?usp=drive_link',
 'Описание очередности', 40, 'Описание противопоказаний');

INSERT INTO exercise (body, title, description_exercise, url, order_use, time, contradictions) VALUES
('BOTTOM', 'Растяжка левой икры', 'Встаньте лицом к стене, поставив ноги на ширине плеч.&
Положите руки на стену на уровне плеч.&
Отступите одной ногой назад, удерживая пятку на земле, а ногу прямо.&
Слегка согните переднее колено и наклонитесь вперед, чувствуя растяжение в икрах.&
Держать растяжку 20-30 секунд.&
Поменяйте ноги и повторите растяжку.',
 'https://drive.google.com/file/d/14TjxkSEOdsoNZMm22Z8QqL5nlVl2bIqW/view?usp=drive_link',
 'Описание очередности', 50, 'Описание противопоказаний');

INSERT INTO exercise (body, title, description_exercise, url, order_use, time, contradictions) VALUES
('ALLBODY', 'Морская звезда', 'Встаньте, ноги на ширине плеч.&
Согните колени и опустите тело в присед.&
Резко прыгните вверх, вытягивая ноги и руки.&
Находясь в воздухе, разведите ноги в стороны и разведите руки в стороны.&
Мягко приземлитесь, поставив ноги на ширине плеч и согнув колени, чтобы поглотить удар.&
Повторить желаемое количество повторений.',
 'https://drive.google.com/file/d/1DoZZwB61s8cXTRNh6gFe8Un5LaNqu_8P/view?usp=drive_link',
 'Описание очередности', 50, 'Описание противопоказаний');

INSERT INTO exercise (body, title, description_exercise, url, order_use, time, contradictions) VALUES
('BOTTOM', 'Бег на месте', 'Встаньте, ноги на ширине плеч, руки по бокам.&
Начните с быстрого перемещения ногами вверх и вниз, как будто вы бежите на месте.&
Двигайтесь быстро и легко, сосредоточьтесь на том, чтобы оставаться на подушечках ног.&
Продолжайте желаемую продолжительность или количество повторений.',
 'https://drive.google.com/file/d/19xNx0XvSpo3efFvxBG6BQPUbgpchfseE/view?usp=drive_link',
 'Описание очередности', 60, 'Описание противопоказаний');

INSERT INTO exercise (body, title, description_exercise, url, order_use, time, contradictions) VALUES
('BOTTOM', 'Скалолаз', 'Начните с положения высокой планки, положив руки прямо под плечи, а тело образуя прямую линию.&
Напрягите корпус и поднимите правую ногу от земли, поднеся правое колено к левому локтю.&
Верните правую ногу в исходное положение и повторите движение левой ногой к правому локтю.&
Продолжайте менять стороны, двигаясь в контролируемом темпе.&
Держите бедра ровно, не поднимайте бедра слишком высоко и не опускайте их слишком низко.&
Сохраняйте ровное дыхание на протяжении всего упражнения.&
Повторить желаемое количество повторений.',
 'https://drive.google.com/file/d/1-z9UIyJB_o63fg5M7Jwcgau818BoXj31/view?usp=drive_link',
 'Описание очередности', 50, 'Описание противопоказаний');

INSERT INTO exercise (body, title, description_exercise, url, order_use, time, contradictions) VALUES
('BOTTOM', 'Растяжка ног', 'Встаньте на четвереньки, положив руки прямо под плечи и колени прямо под бедрами.&
Вытяните одну ногу прямо назад, сохраняя колено согнутым и ступню согнутой.&
Медленно опустите бедра к земле, чувствуя растяжение квадрицепсов.&
Удерживать это положение 20-30 секунд.&
Поменяйте ноги и повторите растяжку с другой стороны.',
 'https://drive.google.com/file/d/1R2JiQlURQ-dyufQFtXhHDnmkonpTJU2M/view?usp=drive_link',
 'Описание очередности', 40, 'Описание противопоказаний');

INSERT INTO exercise (body, title, description_exercise, url, order_use, time, contradictions) VALUES
('UPPER', 'Растяжка рук', 'Встаньте, ноги на ширине плеч, руки вытянуты перед собой.&
Вытяните правую руку в сторону параллельно земле ладонью вниз.&
Левой рукой возьмите правую руку и осторожно потяните ее к себе, чувствуя растяжение в правом предплечье.&
Удерживайте растяжку 15–30 секунд, затем расслабьтесь.&
Повторите с другой стороны.',
 'https://drive.google.com/file/d/1GKKq8XYGEELhVbP1DKsWzsdnKGZ89Ujp/view?usp=drive_link',
 'Описание очередности', 40, 'Описание противопоказаний');

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
values (1, 'Мощный пресс - fitness', 'Описание тренировки', 1, 60, 2, 'PRESS');

insert into training (id, title, description_training, customer_id, time, type_training_id, body)
values (2, 'Пресс и тело', 'Описание тренировки', 1, 50, 1, 'ALLBODY');

insert into training (id, title, description_training, customer_id, time, type_training_id, body)
values (3, 'Экспресс-фитнес', 'Описание тренировки', 3, 30, 3, 'ALLBODY');

insert into training (id, title, description_training, customer_id, time, type_training_id, body)
values (4, 'Мощный торс', 'Описание тренировки', 3, 60, 3, 'UPPER');

insert into training (id, title, description_training, customer_id, time, type_training_id, body)
values (5, 'Ноги-молоты', 'Описание тренировки', 2, 50, 1, 'BOTTOM');

insert into training (id, title, description_training, customer_id, time, type_training_id, body)
values (6, 'Взбодрись', 'Описание тренировки', 1, 40, 1, 'ALLBODY');

insert into training (id, title, description_training, customer_id, time, type_training_id, body)
values (7, 'Бицепс-бум', 'Описание тренировки', 1, 40, 1, 'UPPER');

insert into training (id, title, description_training, customer_id, time, type_training_id, body)
values (8, 'Вечерняя', 'Описание тренировки', 1, 40, 4, 'UPPER');

insert into training (id, title, description_training, customer_id, time, type_training_id, body)
values (9, 'Силовая', 'Описание тренировки', 1, 40, 4, 'ALLBODY');

insert into training (id, title, description_training, customer_id, time, type_training_id, body)
values (10, 'Растяжка', 'Описание тренировки', 1, 40, 2, 'ALLBODY');

insert into training_exercise (training_id, exercise_id, approach, priority) values (1, 1, 4, 1);
insert into training_exercise (training_id, exercise_id, approach, priority) values (1, 8, 4, 2);
insert into training_exercise (training_id, exercise_id, approach, priority) values (1, 9, 3, 3);
insert into training_exercise (training_id, exercise_id, approach, priority) values (1, 17, 4, 4);
insert into training_exercise (training_id, exercise_id, approach, priority) values (1, 18, 3, 5);

insert into training_exercise (training_id, exercise_id, approach, priority) values (2, 1, 3, 1);
insert into training_exercise (training_id, exercise_id, approach, priority) values (2, 31, 3, 4);
insert into training_exercise (training_id, exercise_id, approach, priority) values (2, 12, 2, 3);
insert into training_exercise (training_id, exercise_id, approach, priority) values (2, 1, 3, 2);
insert into training_exercise (training_id, exercise_id, approach, priority) values (2, 10, 3, 1);

insert into training_exercise (training_id, exercise_id, approach, priority) values (3, 2, 3, 1);
insert into training_exercise (training_id, exercise_id, approach, priority) values (3, 10, 3, 2);
insert into training_exercise (training_id, exercise_id, approach, priority) values (3, 11, 3, 3);
insert into training_exercise (training_id, exercise_id, approach, priority) values (3, 12, 4, 4);
insert into training_exercise (training_id, exercise_id, approach, priority) values (3, 1, 3, 5);

insert into training_exercise (training_id, exercise_id, approach, priority) values (4, 6, 3, 1);
insert into training_exercise (training_id, exercise_id, approach, priority) values (4, 15, 3, 2);
insert into training_exercise (training_id, exercise_id, approach, priority) values (4, 32, 3, 3);
insert into training_exercise (training_id, exercise_id, approach, priority) values (4, 16, 4, 4);
insert into training_exercise (training_id, exercise_id, approach, priority) values (4, 3, 3, 5);

insert into training_exercise (training_id, exercise_id, approach, priority) values (5, 21, 4, 1);
insert into training_exercise (training_id, exercise_id, approach, priority) values (5, 22, 4, 2);
insert into training_exercise (training_id, exercise_id, approach, priority) values (5, 23, 4, 3);
insert into training_exercise (training_id, exercise_id, approach, priority) values (5, 24, 3, 4);
insert into training_exercise (training_id, exercise_id, approach, priority) values (5, 25, 3, 5);
insert into training_exercise (training_id, exercise_id, approach, priority) values (5, 26, 3, 6);

insert into training_exercise (training_id, exercise_id, approach, priority) values (6, 6, 3, 1);
insert into training_exercise (training_id, exercise_id, approach, priority) values (6, 7, 3, 2);
insert into training_exercise (training_id, exercise_id, approach, priority) values (6, 10, 3, 3);
insert into training_exercise (training_id, exercise_id, approach, priority) values (6, 2, 3, 4);
insert into training_exercise (training_id, exercise_id, approach, priority) values (6, 11, 3, 5);
insert into training_exercise (training_id, exercise_id, approach, priority) values (6, 3, 3, 9);
insert into training_exercise (training_id, exercise_id, approach, priority) values (6, 8, 3, 8);
insert into training_exercise (training_id, exercise_id, approach, priority) values (6, 31, 3, 7);
insert into training_exercise (training_id, exercise_id, approach, priority) values (6, 32, 3, 6);

insert into training_exercise (training_id, exercise_id, approach, priority) values (7, 3, 4, 1);
insert into training_exercise (training_id, exercise_id, approach, priority) values (7, 15, 4, 2);
insert into training_exercise (training_id, exercise_id, approach, priority) values (7, 16, 4, 3);
insert into training_exercise (training_id, exercise_id, approach, priority) values (7, 19, 3, 4);
insert into training_exercise (training_id, exercise_id, approach, priority) values (7, 20, 3, 5);
insert into training_exercise (training_id, exercise_id, approach, priority) values (7, 4, 3, 6);

insert into training_exercise (training_id, exercise_id, approach, priority) values (8, 6, 2, 1);
insert into training_exercise (training_id, exercise_id, approach, priority) values (8, 24, 2, 2);
insert into training_exercise (training_id, exercise_id, approach, priority) values (8, 21, 2, 3);

insert into training_exercise (training_id, exercise_id, approach, priority) values (9, 15, 5, 1);
insert into training_exercise (training_id, exercise_id, approach, priority) values (9, 1, 5, 2);
insert into training_exercise (training_id, exercise_id, approach, priority) values (9, 32, 5, 3);
insert into training_exercise (training_id, exercise_id, approach, priority) values (9, 13, 4, 4);
insert into training_exercise (training_id, exercise_id, approach, priority) values (9, 3, 4, 5);
insert into training_exercise (training_id, exercise_id, approach, priority) values (9, 4, 4, 6);

insert into training_exercise (training_id, exercise_id, approach, priority) values (9, 15, 5, 1);
insert into training_exercise (training_id, exercise_id, approach, priority) values (9, 1, 5, 2);
insert into training_exercise (training_id, exercise_id, approach, priority) values (9, 32, 5, 3);
insert into training_exercise (training_id, exercise_id, approach, priority) values (9, 13, 4, 4);
insert into training_exercise (training_id, exercise_id, approach, priority) values (9, 3, 4, 5);
insert into training_exercise (training_id, exercise_id, approach, priority) values (9, 4, 4, 6);

insert into training_exercise (training_id, exercise_id, approach, priority) values (10, 2, 3, 1);
insert into training_exercise (training_id, exercise_id, approach, priority) values (10, 31, 3, 2);
insert into training_exercise (training_id, exercise_id, approach, priority) values (10, 32, 3, 3);
insert into training_exercise (training_id, exercise_id, approach, priority) values (10, 5, 3, 4);
insert into training_exercise (training_id, exercise_id, approach, priority) values (10, 6, 3, 5);
insert into training_exercise (training_id, exercise_id, approach, priority) values (10, 7, 3, 6);
















































