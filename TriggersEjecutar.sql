DELIMITER $$

CREATE TRIGGER trg_detalles_carrito_after_insert
AFTER INSERT ON detalles_carrito
FOR EACH ROW
BEGIN
    UPDATE carritos
    SET total = (
        SELECT IFNULL(SUM(importe), 0)
        FROM detalles_carrito
        WHERE id_carrito = NEW.id_carrito
    )
    WHERE id_carrito = NEW.id_carrito;
END$$

DELIMITER ; 

DELIMITER $$

CREATE TRIGGER trg_detalles_carrito_after_delete
AFTER DELETE ON detalles_carrito
FOR EACH ROW
BEGIN
    UPDATE carritos
    SET total = (
        SELECT IFNULL(SUM(importe), 0)
        FROM detalles_carrito
        WHERE id_carrito = OLD.id_carrito
    )
    WHERE id_carrito = OLD.id_carrito;
END$$

DELIMITER ;


DELIMITER $$

CREATE TRIGGER trg_detalles_carrito_au
AFTER UPDATE ON detalles_carrito
FOR EACH ROW
BEGIN
    UPDATE carritos
    SET total = (
        SELECT IFNULL(SUM(importe), 0)
        FROM detalles_carrito
        WHERE id_carrito = NEW.id_carrito
    )
    WHERE id_carrito = NEW.id_carrito;
END$$

DELIMITER ;






-- Trigger para calcular el total de pedido cuando se inserta algo en detalles_pedido

DELIMITER $$

CREATE TRIGGER trg_actualizar_total_pedido_ai
AFTER INSERT ON detalles_pedido
FOR EACH ROW
BEGIN
    DECLARE totalPedido DOUBLE;

    -- Recalcular el total del pedido
    SELECT SUM(dp.cantidad * p.precio)
    INTO totalPedido
    FROM detalles_pedido dp
    JOIN productos p ON p.id_producto = dp.id_producto
    WHERE dp.id_pedido = NEW.id_pedido;

    -- Actualizar el total del pedido
    UPDATE pedidos
    SET total = IFNULL(totalPedido, 0)
    WHERE id_pedido = NEW.id_pedido;
END$$

DELIMITER ;