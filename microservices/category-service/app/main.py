from fastapi import FastAPI, HTTPException
from pydantic import BaseModel
from typing import List
from uuid import uuid4
import requests

app = FastAPI(title="Category Service API")

class Category(BaseModel):
    id: str
    name: str
    description: str | None = None

class CategoryCreate(BaseModel):
    name: str
    description: str | None = None

class Product(BaseModel):
    id: int
    name: str
    description: str
    price: float
    stock: int
    createdBy: str

# Simulación de base de datos en memoria
categories: List[Category] = []

@app.get("/api/categories", response_model=List[Category])
def get_all_categories():
    return categories

@app.get("/api/categories/{category_id}", response_model=Category)
def get_category(category_id: str):
    for cat in categories:
        if cat.id == category_id:
            return cat
    raise HTTPException(status_code=404, detail="Categoría no encontrada")

@app.post("/api/categories", response_model=Category)
def create_category(category: CategoryCreate):
    new_category = Category(id=str(uuid4()), **category.dict())
    categories.append(new_category)
    return new_category

@app.put("/api/categories/{category_id}", response_model=Category)
def update_category(category_id: str, category: CategoryCreate):
    for i, cat in enumerate(categories):
        if cat.id == category_id:
            updated = Category(id=category_id, **category.dict())
            categories[i] = updated
            return updated
    raise HTTPException(status_code=404, detail="Categoría no encontrada")

@app.delete("/api/categories/{category_id}")
def delete_category(category_id: str):
    for i, cat in enumerate(categories):
        if cat.id == category_id:
            categories.pop(i)
            return {"message": "Categoría eliminada"}
    raise HTTPException(status_code=404, detail="Categoría no encontrada")

@app.get("/api/categories/{category_id}/products", response_model=List[Product])
def get_products_by_category(category_id: str):
    # Simulación de llamada a product-service (esto requiere que el otro microservicio esté corriendo)
    try:
        response = requests.get(f"http://localhost:8082/api/products")
        if response.status_code == 200:
            return response.json()
        else:
            raise HTTPException(status_code=response.status_code, detail="Error al consultar productos")
    except Exception as e:
        raise HTTPException(status_code=500, detail=str(e))
