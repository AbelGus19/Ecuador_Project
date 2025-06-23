from fastapi import APIRouter, Depends, Request, HTTPException, status
from sqlalchemy.orm import Session
from app.database import get_db
from app.schemas.inventory_schema import InventoryRequest, InventoryResponse
from app.models.inventory_model import Inventory
from app.auth.auth_middleware import get_current_user
from typing import List

router = APIRouter(prefix="/api/inventory", tags=["Inventory"])

@router.post("", response_model=InventoryResponse)
def create_inventory(
    req: InventoryRequest,
    db: Session = Depends(get_db),
    user: str = Depends(get_current_user),
):
    inventory = Inventory(**req.dict(), owner=user)
    db.add(inventory)
    db.commit()
    db.refresh(inventory)
    return inventory

@router.get("/my", response_model=List[InventoryResponse])
def get_my_inventory(
    db: Session = Depends(get_db),
    user: str = Depends(get_current_user),
):
    return db.query(Inventory).filter(Inventory.owner == user).all()
