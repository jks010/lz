CREATE TABLE lz_users (
    "id" BIGINT NOT NULL GENERATED ALWAYS AS IDENTITY,
    "name" VARCHAR(50) NOT NULL,
    CONSTRAINT "PK_users_id" PRIMARY KEY ("id")
);


CREATE TABLE lz_profiles (
    "id" BIGINT NOT NULL GENERATED ALWAYS AS IDENTITY,
    "description" VARCHAR(50) NOT NULL,
    "user_id" BIGINT NOT NULL,
    CONSTRAINT "PK_profiles_id" PRIMARY KEY ("id"),
    CONSTRAINT "FK_user_id" FOREIGN KEY ("user_id") REFERENCES "lz_users" ("id")
);

