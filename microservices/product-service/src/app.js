const express = require('express');
const cors = require('cors');
const mongoose = require('mongoose');
require('dotenv').config();

const app = express();
app.use(cors());
app.use(express.json());

// Swagger setup
const swaggerUI = require('swagger-ui-express');
const swaggerSpec = require('./config/swagger');
app.use('/api-docs', swaggerUI.serve, swaggerUI.setup(swaggerSpec));

// MongoDB connection
mongoose.connect(process.env.MONGO_URI)
  .then(() => console.log('MongoDB conectado'))
  .catch(err => console.error(err));

// Default route
app.get('/', (req, res) => res.send('Product Service funcionando'));

// Product routes
const productRoutes = require('./routes/product.routes');
app.use('/api/products', productRoutes);

// Server port
const PORT = process.env.PORT || 3000;
app.listen(PORT, () => console.log(`Servidor corriendo en puerto ${PORT}`));
