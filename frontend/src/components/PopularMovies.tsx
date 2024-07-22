import React, { useEffect, useState } from 'react';
import { getPopularMovies } from '../services/movieService';
import { Movies, Result, OriginalLanguage } from '../types/movieType';

function PopularMovies() {
    const [popularMovies, setPopularMovies] = useState<Result[]>([]);
    useEffect(() => {
        getPopularMovies().then(data => {
            setPopularMovies(data.results);
        })
    })
    
    return (
        <div>
            <h1>Popular Movies</h1>
            <ul>
                {popularMovies.map(movie => (
                    <li key={movie.id}>{movie.title}</li>
                ))}
            </ul>
        </div>
    );
}

export default PopularMovies;