const Payment = require('../models/Payment');

exports.createPayment = async (req, res) => {
  try {
    const { orderId, amount, method } = req.body;
    const payment = new Payment({ orderId, amount, method, paidBy: req.user });
    await payment.save();
    res.status(201).json(payment);
  } catch (err) {
    res.status(500).json({ error: err.message });
  }
};

exports.getMyPayments = async (req, res) => {
  try {
    const payments = await Payment.find({ paidBy: req.user });
    res.json(payments);
  } catch (err) {
    res.status(500).json({ error: err.message });
  }
};