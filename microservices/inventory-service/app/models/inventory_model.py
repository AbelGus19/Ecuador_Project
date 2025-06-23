from sqlalchemy import Column, Integer, String
from app.database import Base

class Inventory(Base):
    __tablename__ = "inventories"

    id = Column(Integer, primary_key=True, index=True)
    product_name = Column(String, nullable=False)
    quantity = Column(Integer, nullable=False)
    location = Column(String, nullable=False)
    owner = Column(String, nullable=False)  # Se extrae del token JWT
