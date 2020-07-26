-----------------------------------covid_master_questions--------------------------------

CREATE TABLE public.covid_master_questions
(
    question_id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
	symbolic_image_id integer,
    type_of_options character varying(10) COLLATE pg_catalog.default,
	created_by character varying(50) COLLATE pg_catalog.default,
	creation_date date,
	updated_date date,
	status character varying(1) COLLATE pg_catalog.default,
	eligible_locations character varying(1000) COLLATE pg_catalog.default,
    CONSTRAINT question_id_pkey PRIMARY KEY (question_id),
	CONSTRAINT covid_master_questions_symbolic_image_id_fkey FOREIGN KEY (symbolic_image_id)
        REFERENCES public.disease_symbolic_images (image_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

-----------------------------------covid_master_questions_extension--------------------------------

CREATE TABLE public.covid_master_questions_extension
(
    question_id integer NOT NULL,
	language  character varying(2) COLLATE pg_catalog.default,
    question_string character varying(2000) COLLATE pg_catalog.default,
	option1 character varying(200) COLLATE pg_catalog.default,
	option2 character varying(200) COLLATE pg_catalog.default,
	option3 character varying(200) COLLATE pg_catalog.default,
	option4 character varying(200) COLLATE pg_catalog.default,
	option5 character varying(200) COLLATE pg_catalog.default,
	answer_string character varying(200) COLLATE pg_catalog.default,
	additional_attribute1 character varying(100) COLLATE pg_catalog.default,
	additional_attribute2 character varying(100) COLLATE pg_catalog.default,
	additional_attribute3 character varying(100) COLLATE pg_catalog.default,
	additional_attribute4 character varying(100) COLLATE pg_catalog.default,
	additional_attribute5 character varying(100) COLLATE pg_catalog.default,
	created_by character varying(50) COLLATE pg_catalog.default,
	creation_date date,
	updated_date date,
	CONSTRAINT covid_master_questions_extension_question_id_fkey FOREIGN KEY (question_id)
        REFERENCES public.covid_master_questions (question_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

-----------------------------------disease_symbolic_images--------------------------------

CREATE TABLE public.disease_symbolic_images
(
    image_id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    image_type character varying(15) DEFAULT 'CovidImage',
	biased_image  character varying(1) DEFAULT 'Y',
	image_path character varying(150) COLLATE pg_catalog.default,
	file_saved_date_time timestamp without time zone default (now() at time zone 'utc'),
    CONSTRAINT disease_symbolic_images_pkey PRIMARY KEY (image_id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

-----------------------------------covid_questions_set--------------------------------

CREATE TABLE public.covid_questions_set
(
    question_set_id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
	question_set_name  character varying(50) COLLATE pg_catalog.default,
	language  character varying(2) COLLATE pg_catalog.default,
	location_id integer NOT NULL,
    no_of_questions integer,
	list_of_question_ids character varying(200) COLLATE pg_catalog.default,
	status character varying(1) COLLATE pg_catalog.default,
	created_by character varying(50) COLLATE pg_catalog.default,
	creation_date date,
	updated_date date,
    CONSTRAINT covid_questions_set_pkey PRIMARY KEY (question_set_id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

-----------------------------------user_responses--------------------------------

CREATE TABLE public.user_responses
(
    user_id integer NOT NULL,
	question_set_id  integer NOT NULL,
	location_id integer NOT NULL,
	language  character varying(2) COLLATE pg_catalog.default,
	assessment_date date,
	upcoming_assessment_date date,
	status character varying(1) COLLATE pg_catalog.default,	
	assessment_number integer,
	CONSTRAINT user_responses_fkey FOREIGN KEY (user_id)
        REFERENCES public.users (user_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
	CONSTRAINT user_responses_question_set_id_fkey FOREIGN KEY (question_set_id)
        REFERENCES public.covid_questions_set (question_set_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
	CONSTRAINT user_responses_location_id_fkey FOREIGN KEY (location_id)
        REFERENCES public.location_hierarchy (location_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
	
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

-----------------------------------user_responses_extension--------------------------------

CREATE TABLE public.user_responses_extension
(
    user_id integer NOT NULL,
	question_set_id  integer NOT NULL,
	question_id integer NOT NULL,
	option1 character varying(200) COLLATE pg_catalog.default,
	option2 character varying(200) COLLATE pg_catalog.default,
	option3 character varying(200) COLLATE pg_catalog.default,
	option4 character varying(200) COLLATE pg_catalog.default,
	option5 character varying(200) COLLATE pg_catalog.default,
	response_given_by_user  character varying(200) COLLATE pg_catalog.default,
	correct_answer  character varying(200) COLLATE pg_catalog.default,
	result character varying(1) COLLATE pg_catalog.default,	
	assessment_date date,
	CONSTRAINT user_responses_extension_user_id_fkey FOREIGN KEY (user_id)
        REFERENCES public.users (user_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
	CONSTRAINT user_responses_extension_question_set_id_fkey FOREIGN KEY (question_set_id)
        REFERENCES public.covid_questions_set (question_set_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
	CONSTRAINT user_responses_extension_question_id_fkey FOREIGN KEY (question_id)
        REFERENCES public.covid_master_questions (question_id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

----------------------------------------------------------------------------------------------
