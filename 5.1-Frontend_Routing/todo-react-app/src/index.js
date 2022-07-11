import React from 'react';
import './index.css';
import reportWebVitals from './reportWebVitals';
import { createRoot } from 'react-dom/client';
import AppRouter from './AppRouter';

const container = document.getElementById('root');

const root = createRoot(container); 

root.render(<AppRouter tab="home" />);

reportWebVitals();
