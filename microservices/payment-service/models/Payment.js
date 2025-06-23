const mongoose = require('mongoose');

const PaymentSchema = new mongoose.Schema({
  orderId: { type: String, required: true },
  amount: { type: Number, required: true },
  method: { type: String, required: true },
  paidAt: { type: Date, default: Date.now },
  paidBy: { type: String, required: true }
});

module.exports = mongoose.model('Payment', PaymentSchema);