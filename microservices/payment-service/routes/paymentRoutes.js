const express = require('express');
const router = express.Router();
const paymentController = require('../controllers/paymentController');
const authenticate = require('../middleware/auth');

router.post('/', authenticate, paymentController.createPayment);
router.get('/my', authenticate, paymentController.getMyPayments);

module.exports = router;