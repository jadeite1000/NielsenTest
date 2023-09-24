

CREATE TABLE public.product (
	id int8 NOT NULL,
	brand varchar(255) NULL,
	category varchar(255) NULL,
	productid varchar(255) NULL,
	relevancy_score float8 NULL,
	CONSTRAINT product_pkey PRIMARY KEY (id)
);

CREATE TABLE public.shopper (
	id varchar(255) NOT NULL,
	CONSTRAINT shopper_pkey PRIMARY KEY (id)
);

CREATE TABLE public.shopper_product (
	shopper_id varchar(255) NULL,
	id int8 NOT NULL,
	CONSTRAINT shopper_product_pkey PRIMARY KEY (id)
);


-- public.shopper_product foreign keys

ALTER TABLE public.shopper_product ADD CONSTRAINT fk10gf0331jhng16dyofioj9ik9 FOREIGN KEY (shopper_id) REFERENCES public.shopper(id);
ALTER TABLE public.shopper_product ADD CONSTRAINT fksfdqaxlu1c33kptbct97e4vfn FOREIGN KEY (id) REFERENCES public.product(id);