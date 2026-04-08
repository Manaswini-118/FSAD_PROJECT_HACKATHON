import React from 'react';
import ReactDOM from 'react-dom/client';
import App from './App';
import './App.css';   // 🔥 FORCE CSS HERE

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode>
    <App />
  </React.StrictMode>
);