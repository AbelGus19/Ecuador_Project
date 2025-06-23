# Inventory Service

Microservicio para gestionar el inventario de productos.

## Endpoints

- `POST /api/inventory` - Crear o actualizar inventario
- `GET /api/inventory/{product_id}` - Obtener inventario de un producto
- `GET /api/inventory/all` - Listar todo el inventario

## Seguridad

Todas las rutas requieren un token JWT válido en el header:
`Authorization: Bearer <token>`

## Ejecución

```
pip install -r requirements.txt
uvicorn app.main:app --reload
```
