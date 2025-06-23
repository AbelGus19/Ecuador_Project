from sqlalchemy import create_engine
from sqlalchemy.ext.declarative import declarative_base
from sqlalchemy.orm import sessionmaker

# URL de conexión a SQLite
SQLALCHEMY_DATABASE_URL = "sqlite:///./inventory.db"

# Crear el engine
engine = create_engine(
    SQLALCHEMY_DATABASE_URL, connect_args={"check_same_thread": False}
)

# Crear el SessionLocal
SessionLocal = sessionmaker(autocommit=False, autoflush=False, bind=engine)

# Declarar el modelo base
Base = declarative_base()

# Función que se usará como dependencia para obtener sesión de DB
def get_db():
    db = SessionLocal()
    try:
        yield db
    finally:
        db.close()
