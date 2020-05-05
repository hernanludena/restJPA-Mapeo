CREATE TABLE cliente
(
  cedula character varying NOT NULL,
  nombre character varying,
  apellido character varying,
  direccion character varying,
  telefono character varying,
  CONSTRAINT cliente_pk PRIMARY KEY (cedula)
);


CREATE TABLE categoria(
    id serial not null,
    nombre character varying,
  CONSTRAINT categoria_pk PRIMARY KEY (id) 	
);
/** En la prueba se agregan productos por categoria */

CREATE TABLE producto
(
  codigo character varying(4) NOT NULL,
  nombre character varying,
  precio_venta numeric(8,2),
  impuesto boolean,/**true con iva, false sin iva**/
  id_categoria integer NOT NULL,
  CONSTRAINT producto_pk PRIMARY KEY (codigo),
  CONSTRAINT fk_categoria FOREIGN KEY (id_categoria)
      REFERENCES categoria (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);



/***impuesto de otro lado**/
CREATE TABLE factura
(
    fac_codigo character varying NOT NULL,
    fac_fecha time without time zone,
    fac_total numeric(8,2),
    fac_id_cliente character varying NOT NULL,
    CONSTRAINT factura_pk PRIMARY KEY (fac_codigo),
     CONSTRAINT fk_cliente FOREIGN KEY (fac_id_cliente)
      REFERENCES cliente (cedula) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);


CREATE TABLE factura_detalle
(
    fd_codigo serial not null,
    fd_id_producto character varying not null,
    fd_cantidad integer,
    fd_id_factura character varying not null,
    CONSTRAINT factura_detalle_pk PRIMARY KEY (fd_codigo),
    CONSTRAINT fk_factura FOREIGN KEY (fd_id_factura)
    REFERENCES factura (fac_codigo) MATCH SIMPLE
    ON UPDATE NO ACTION ON DELETE NO ACTION,
    CONSTRAINT fk_producto FOREIGN KEY (fd_id_producto)
    REFERENCES producto (codigo) MATCH SIMPLE
    ON UPDATE NO ACTION ON DELETE NO ACTION
);

CREATE TABLE rol
(
  ro_id smallint NOT NULL,
  ro_descripcion character varying,
  CONSTRAINT pk_ad_rol PRIMARY KEY (ro_id)
);

CREATE TABLE menu
(
  me_id integer NOT NULL,
  me_id_padre integer,
  nombre character varying,
  visible boolean,
  url character varying,
  CONSTRAINT menu_pk PRIMARY KEY (me_id),
  CONSTRAINT fk_menu FOREIGN KEY (me_id_padre)
      REFERENCES menu (me_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);

CREATE TABLE menu_rol
(
  mro_id_menu integer NOT NULL,
  mro_id_rol smallint NOT NULL,
  fecha_asignacion time without time zone,
  CONSTRAINT pk_menu_rol PRIMARY KEY (mro_id_menu, mro_id_rol),
  CONSTRAINT fk_rol FOREIGN KEY (mro_id_rol)
      REFERENCES rol (ro_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_menu FOREIGN KEY (mro_id_menu)
      REFERENCES menu (me_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);

CREATE TABLE usuario
(
  us_id serial NOT NULL,
  us_usuario character varying NOT NULL,
  us_clave character varying NOT NULL,
  us_nombre character varying NOT NULL,
  us_apellido character varying NOT NULL,
  CONSTRAINT pk_usuario PRIMARY KEY (us_id)
);


CREATE TABLE usuario_rol
(
  uro_id_usuario integer NOT NULL,
  uro_id_rol integer NOT NULL,
  uro_activo boolean NOT NULL,
  CONSTRAINT pk_usuario_rol PRIMARY KEY (uro_id_usuario,uro_id_rol),
  CONSTRAINT fk_ur_usuario FOREIGN KEY (uro_id_usuario)
      REFERENCES usuario (us_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_ur_rol FOREIGN KEY (uro_id_rol)
      REFERENCES rol (ro_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);


CREATE TABLE inventario
(
  id_inventario serial NOT NULL,
  id_producto character varying,
  fecha_inventario date,
  cantidad_producto integer,
  operacion_inventario integer,
  CONSTRAINT pk_inventario PRIMARY KEY (id_inventario ),
  CONSTRAINT fk_producto FOREIGN KEY (id_producto)
      REFERENCES producto (codigo) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE inventario
  OWNER TO postgres;