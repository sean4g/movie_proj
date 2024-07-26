import { Movies } from "../../../client/src/types/movieType";

export const getPopularMovies = async (): Promise<Movies> => {
    const response = await fetch('/api/movies/popular');

    if (!response.ok) {
      throw new Error(`HTTP error! status: ${response.status}`);
    }
  
    const data: Movies = await response.json();
  
    if (!data) {
      throw new Error('No data returned from API');
    }
  
    return data;

};