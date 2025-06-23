from sqlalchemy import Column, Integer, String
from app.database import Base

class Inventory(Base):
    __tablename__ = "inventory"
    id = Column(Integer, primary_key=True, index=True)
    product_id = Column(String, unique=True, index=True)
    stock = Column(Integer)
