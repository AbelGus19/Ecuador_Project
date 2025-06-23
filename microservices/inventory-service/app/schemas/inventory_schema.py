from pydantic import BaseModel, Field
from typing import Optional

class InventoryRequest(BaseModel):
    product_name: str = Field(..., example="Vasija artesanal")
    quantity: int = Field(..., ge=0, example=50)
    location: str = Field(..., example="Cuenca")

class InventoryResponse(InventoryRequest):
    id: int
    owner: str

    class Config:
        from_attributes = True  # Para permitir convertir desde ORM
