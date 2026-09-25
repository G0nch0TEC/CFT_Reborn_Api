-- ==================================
-- UNIONES
-- ==================================

ALTER TABLE CLIENTES 
	ADD CONSTRAINT Fk_Cliente
		FOREIGN KEY (cli_usr_id) REFERENCES USUARIO(usr_id);
        
ALTER TABLE CLIENTES
	ADD CONSTRAINT Fk_Cliente2
    FOREIGN KEY (cli_estado_id) REFERENCES ESTADO(est_id);
    
ALTER TABLE PRODUCTO
	ADD CONSTRAINT Fk_Producto
		FOREIGN KEY (prod_cat_id) REFERENCES CATEGORIA(cat_id);
        
ALTER TABLE PEDIDO
	ADD CONSTRAINT FK_Pedido
		FOREIGN KEY (ped_cli_id) REFERENCES CLIENTES(cli_id);
        
ALTER TABLE DETALLE_PEDIDO
	ADD CONSTRAINT FK_Detalle_Pedido
		FOREIGN KEY (det_ped_id) REFERENCES PEDIDO(ped_id),
	ADD CONSTRAINT FK_Detalle_Pedido2
		FOREIGN KEY (det_prod_id) REFERENCES PRODUCTO(prod_id);
        
        
ALTER TABLE PAGO
    ADD CONSTRAINT fk_pago_cliente
		FOREIGN KEY (pago_cli_id) REFERENCES CLIENTES(cli_id);