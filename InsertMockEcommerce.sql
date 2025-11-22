CREATE DATABASE ecommerce3;	
USE ecommerce3;

INSERT INTO CATEGORIAS(ID_CATEGORIA, DESCRIPCION, NOMBRE) VALUES
(1,"ACCESORIOS PARA TU AUTO", "MISCELÁNEOS"),
(2, 'SISTEMAS ELÉCTRICOS, ENCENDIDO Y COMPONENTES', 'ELÉCTRICO Y ENCENDIDO'),
(3, 'ILUMINACIÓN AUTOMOTRIZ, FAROS Y ACCESORIOS', 'ILUMINACIÓN'),
(4, 'BUJÍAS Y COMPONENTES DE IGNICIÓN', 'BUJÍAS'),
(5, 'LLANTAS PARA AUTOMÓVIL Y CAMIONETA', 'LLANTAS'),
(6, 'SISTEMAS DE FRENADO Y ACCESORIOS', 'FRENOS'),
(7, 'PIEZAS DE TRANSMISIÓN MANUAL Y AUTOMÁTICA', 'TRANSMISIÓN'),
(8, 'ACCESORIOS GENERALES PARA EL VEHÍCULO', 'ACCESORIOS');


INSERT INTO USUARIOS (nombre, correo ,contraseña, direccion, esActivo, telefono, rol) 
VALUES
("Gael Guerra", "gael@itson.mx", "046185352dd669176a9992ece137fbaf5d65734c289707786758f5c53dbbc523", 
"Casa Blanca #2971 85130", TRUE, "6445768990","CLIENTE"), /*La contraseña de Gael es 'refaccionesMorales1911*' */
("Juan Heras", "juan@itson.mx", "4abac42a1157ef465ad7eee8443b1d88c1553d1df7bf652be05b561025213509", 
"Real del Arco #207 85149", TRUE,"6441217654", "CLIENTE"), /*La contraseña de Juan Heras es 'werevertumorrocrewW2M' */
("Pedro Morales", "pedro@itson.mx", "501e4bd27a426b77e68da7e24b2601cfa14477e6ec50e5d5cac6aa9eb9611271", 
"Col. Bellavista al lado del six de la paris 85150", TRUE, "6443245670", "ADMINISTRADOR"), /*La contraseña de Pedro es 'miPerroPulgoso2456' */
("Ramón Zamudio", "ramon@itson.mx", "240be518fabd2724ddb6f04eeb1da5967448d7e831c08c8fa822809f74c720a9", 
"Michoacan #323 85154 ", TRUE, "6448907622", "ADMINISTRADOR"); /*La contraseña de Ramón es 'admin123' */


INSERT INTO PRODUCTOS (NOMBRE, DESCRIPCION,  PRECIO, STOCK, ID_CATEGOIA, DISPONIBILIDAD, ESPECIFICACIONES_TECNICAS, RUTAIMAGEN)
VALUES 
-- MISCEÁNEOS (1)
("Llavero Mazda", "Llavero de decoración gris marca Mazda", 125, 21, 1, TRUE, "7cm", "imgs/llavero_mazda.jpg"),
("Aromatizante Vainilla", "Aromatizante para auto con aroma a vainilla", 45, 50, 1, TRUE, "Duración 30 días", "imgs/aromatizante_vainilla.jpg"),

-- ELÉCTRICO Y ENCENDIDO (2)
("Batería LTH 12V", "Batería automotriz de ácido-plomo 12V", 1850, 10, 2, TRUE, "CCA 600A", "imgs/bateria_lth.jpg"),
("Alternador Bosch", "Alternador para motor 4 cilindros", 2500, 5, 2, TRUE, "12V - 90A", "imgs/alternador_bosch.png"),

-- ILUMINACIÓN (3)
("Faro LED H11", "Faro LED blanco brillante para auto", 399, 30, 3, TRUE, "6000K, 50W", "imgs/faro_led_h11.avif"),
("Cuartos Ámbar Universal", "Juego de cuartos ámbar para auto", 120, 40, 3, TRUE, "Compatibles universal", "imgs/cuartos_ambar.jpg"),

-- BUJÍAS (4)
("Bujía NGK Iridium", "Bujía de iridio para motor 4 cilindros", 165, 25, 4, TRUE, "Gap 0.044", "imgs/bujia_ngk.jpg"),
("Bujía Bosch Platinum", "Bujía de platino de larga duración", 140, 20, 4, TRUE, "Electrodo fino", "imgs/bujia_bosch.jpg"),

-- LLANTAS (5)
("Llanta Michelin 205/55 R16", "Llanta de alto rendimiento Michelin", 1850, 14, 5, TRUE, "Índice 91V", "imgs/llanta_michelin.jpg"),
("Llanta Bridgestone 195/65 R15", "Llanta para auto compactos", 1650, 12, 5, TRUE, "Índice 89H", "imgs/llanta_bridgestone.jpg"),

-- FRENOS (6)
("Balatas Wagner", "Juego de balatas delanteras", 520, 16, 6, TRUE, "Cerámicas", "imgs/balatas_wagner.png"),
("Disco de Freno Brembo", "Disco ventilado de alto desempeño", 980, 8, 6, TRUE, "280mm", "imgs/disco_brembo.jpg"),

-- TRANSMISIÓN (7)
("Aceite Transmisión ATF", "Aceite sintético para transmisión automática", 190, 30, 7, TRUE, "1L ATF+4", "imgs/aceite_atf.jpg"),
("Filtro de Transmisión", "Filtro interno para transmisiones automáticas", 250, 15, 7, TRUE, "Compatibilidad universal", "imgs/filtro_transmision.jpg"),

-- ACCESORIOS (8)
("Cubreasientos Negros", "Juego de cubreasientos reforzados", 650, 20, 8, TRUE, "Tela resistente", "imgs/cubreasientos.jpg"),
("Tapetes de Hule 3D", "Tapetes de hule antiderrapante para auto", 480, 30, 8, TRUE, "Set de 4 piezas", "imgs/tapetes_3d.jpg");


INSERT INTO RESEÑAS(COMENTARIO, ESTRELLAS, FECHA_HORA, ID_PRODUCTO, ID_USUARIO)
VALUES
("BUEN PRODUCTO, NADA ESPECTACULAR", 4, CURRENT_TIMESTAMP(), 3, 2),
("LLEGÓ RÁPIDO Y FUNCIONA BIEN", 5, CURRENT_TIMESTAMP(), 1, 1),
("SE SIENTE BARATO, PERO SIRVE", 3, CURRENT_TIMESTAMP(), 5, 3),
("NO ES LO QUE ESPERABA, CALIDAD REGULAR", 2, CURRENT_TIMESTAMP(), 8, 4),
("ME ENCANTÓ, SUPERÓ MIS EXPECTATIVAS", 5, CURRENT_TIMESTAMP(), 12, 4),
("PA DECIR QUE ES ORIGINAL, ESTÁ BIEN", 4, CURRENT_TIMESTAMP(), 7, 1),
("NO LO RECOMIENDO MUCHO, HAY MEJORES", 2, CURRENT_TIMESTAMP(), 4, 2),
("FUNCIONA PERFECTO Y EL PRECIO ES BUENO", 5, CURRENT_TIMESTAMP(), 10, 3),
("NORMAL, CUMPLE PERO NO DESTACA", 3, CURRENT_TIMESTAMP(), 6, 4),
("PÉSIMA CALIDAD, SE DAÑÓ RÁPIDO", 1, CURRENT_TIMESTAMP(), 15, 4),
("LA VERDAD SI VOLVERÍA A COMPRARLO", 4, CURRENT_TIMESTAMP(), 9, 1),
("MUY BUENA DURABILIDAD", 5, CURRENT_TIMESTAMP(), 14, 2),
("SE VE BONITO PERO NO ME SIRVIÓ", 2, CURRENT_TIMESTAMP(), 2, 3),
("JUSTO LO QUE NECESITABA", 5, CURRENT_TIMESTAMP(), 11, 4),
("REGULAR, SIN MUCHA CIENCIA", 3, CURRENT_TIMESTAMP(), 13, 4);

INSERT INTO METODO_PAGO(ESTADO, FECHA_HORA, MONTO, TIPO)
VALUES('ACEPTADO', CURRENT_TIMESTAMP(), 254, 'TARJETA'),
('RECHAZADO', CURRENT_TIMESTAMP(), 274, 'TARJETA'),
('ACEPTADO', CURRENT_TIMESTAMP(), 125, 'TRANSFERENCIA'),
('ACEPTADO', CURRENT_TIMESTAMP(), 125, 'CONTRENTREGA');


INSERT INTO pedidos (direccion, estado, fecha_hora, numero_pedido, total, id_usuario, id_metodo_pago)
VALUES 
('Calle Falsa 123, Ciudad A, México', 'ENVIADO', NOW(), 'ECOM0001', 1200.50, 1, 1);

-- Pedido 2: Pagado con Tarjeta (ID_metodo_pago = 2)
INSERT INTO pedidos (direccion, estado, fecha_hora, numero_pedido, total, id_usuario, id_metodo_pago)
VALUES 
('Avenida Siempre Viva 742, Ciudad B, México', 'ENTREGADO', NOW(), 'ECOM0002', 550.00, 2, 2);
-- Detalle Pedido 1: Producto 1 (Bujía) en Pedido 1
-- Pedido 1 compró 5 unidades del Producto 1
INSERT INTO detalles_pedido (cantidad, id_pedido, id_producto)
VALUES 
(5, 1, 1);


-- Detalle Pedido 2: Producto 2 (Aceite) en Pedido 1
-- Pedido 1 también compró 2 unidades del Producto 2
INSERT INTO detalles_pedido (cantidad, id_pedido, id_producto)
VALUES 
(2, 2, 2);

-- Detalle Pedido 3: Producto 2 (Aceite) en Pedido 2
-- Pedido 2 compró 1 unidad del Producto 2
INSERT INTO detalles_pedido (cantidad, id_pedido, id_producto)
VALUES 
(1, 1, 1);

