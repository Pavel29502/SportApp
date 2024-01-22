

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
    title VARCHAR(50) NOT NULL,
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
    body VARCHAR(50),
    title VARCHAR(50) NOT NULL
);

CREATE TABLE exercise_muscle (
    id SERIAL PRIMARY KEY,
    exercise_id INT,
    muscle_id INT,
    FOREIGN KEY (exercise_id) REFERENCES exercise(id),
    FOREIGN KEY (muscle_id) REFERENCES muscle(id)
);

insert into customer (id, name) values (1, 'Ivan');