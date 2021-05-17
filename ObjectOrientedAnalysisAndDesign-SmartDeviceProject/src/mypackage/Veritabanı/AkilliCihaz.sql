--
-- PostgreSQL database dump
--

-- Dumped from database version 13.2
-- Dumped by pg_dump version 13.1

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: Kullanicilar; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public."Kullanicilar" (
    "KullaniciAdi" character varying NOT NULL,
    "Sifre" character varying NOT NULL,
    "Ad" character varying,
    "Soyad" character varying
);


ALTER TABLE public."Kullanicilar" OWNER TO postgres;

--
-- Data for Name: Kullanicilar; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public."Kullanicilar" VALUES
	('ahmet12', 'abc', 'Ahmet', 'Şahin'),
	('ayseylmz', 'bbb', 'Ayşe', 'Yılmaz'),
	('ceren_celik', '111', 'Ceren', 'Çelik'),
	('emirhan.sensoy', '123', 'Emirhan', 'Şensoy');


--
-- Name: Kullanicilar Kullanicilar_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public."Kullanicilar"
    ADD CONSTRAINT "Kullanicilar_pkey" PRIMARY KEY ("KullaniciAdi");


--
-- PostgreSQL database dump complete
--

