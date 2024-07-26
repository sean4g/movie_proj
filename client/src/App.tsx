import React from 'react';
import PopularMovies from './components/PopularMovies';
import Register from './components/Register';
import {  Routes, Route, BrowserRouter} from "react-router-dom";
import './App.css';

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/">
          <Route index element={<PopularMovies/>} />
          <Route path="register" element={<Register />} />
        </Route>
      </Routes>
    </BrowserRouter>
    
  );
}

export default App;
