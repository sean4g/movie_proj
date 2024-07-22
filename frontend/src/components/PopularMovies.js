"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
const jsx_runtime_1 = require("react/jsx-runtime");
const react_1 = require("react");
const movieService_1 = require("../services/movieService");
function PopularMovies() {
    const [popularMovies, setPopularMovies] = (0, react_1.useState)([]);
    (0, react_1.useEffect)(() => {
        (0, movieService_1.getPopularMovies)().then(data => {
            setPopularMovies(data.results);
        });
    });
    return ((0, jsx_runtime_1.jsxs)("div", { children: [(0, jsx_runtime_1.jsx)("h1", { children: "Popular Movies" }), (0, jsx_runtime_1.jsx)("ul", { children: popularMovies.map(movie => ((0, jsx_runtime_1.jsx)("li", { children: movie.title }, movie.id))) })] }));
}
exports.default = PopularMovies;
