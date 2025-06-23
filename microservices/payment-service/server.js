const express = require('express');
const mongoose = require('mongoose');
const paymentRoutes = require('./routes/paymentRoutes');
const swaggerUi = require('swagger-ui-express');
const swaggerDocument = require('./docs/swagger.json');
const app = express();
require('dotenv').config();

app.use(express.json());

app.use('/api/payments', paymentRoutes);
app.use('/api-docs', swaggerUi.serve, swaggerUi.setup(swaggerDocument));

const PORT = process.env.PORT || 8085;

mongoose.connect(process.env.MONGO_URI)
  .then(() => {
    console.log('MongoDB connected');
    app.listen(PORT, () => console.log(`Payment service running on port ${PORT}`));
  })
  .catch(err => console.error(err));