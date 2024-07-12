export const getPopularMovies = async () => {
    try {    
        const response = await fetch('/api/movies/popular');

        if (!response.ok) {
            throw new Error(`HTTP error! status: ${response.status}`);
        }

        const data = await response.json();
        console.log('Movies fetched:', data.results);

        return data;
    } catch (error) {
        console.error('Error fetching movies:', error);
    }

    
    
};