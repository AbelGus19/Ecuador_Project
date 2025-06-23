from fastapi import FastAPI
from fastapi.middleware.cors import CORSMiddleware
from app.routes.inventory_routes import router as inventory_router
import uvicorn

app = FastAPI(
    title="Inventory Service",
    description="API for managing inventory in Ecuador Cerámico",
    version="1.0.0"
)

# Configurar CORS (si se requiere acceso cruzado desde otros orígenes, como un frontend)
app.add_middleware(
    CORSMiddleware,
    allow_origins=["*"],  # En producción deberías especificar los orígenes permitidos
    allow_credentials=True,
    allow_methods=["*"],
    allow_headers=["*"],
)

# Registrar las rutas
app.include_router(inventory_router)

# Para ejecutar directamente si se desea
if __name__ == "__main__":
    uvicorn.run("app.main:app", host="127.0.0.1", port=8000, reload=True)
