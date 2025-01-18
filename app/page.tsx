"use client";

import { useState } from "react";
import Search from "./ui/search";
import ProductCard from "@/app/Components/ProductCard";

// Dados de produtos
const products = [
  {
    id: 1,
    name: "Apple Watch Series 7 GPS, Aluminium Case, Starlight Sport",
    image: "https://flowbite-react.com/images/products/apple-watch.png",
    rating: 5.0,
    price: 599,
  },
  {
    id: 2,
    name: "Samsung Galaxy Watch 4",
    image: "https://flowbite-react.com/images/products/apple-watch.png",
    rating: 4.5,
    price: 399,
  },
  {
    id: 3,
    name: "Fitbit Charge 5",
    image: "https://flowbite-react.com/images/products/apple-watch.png",
    rating: 4.0,
    price: 179,
  },
  {
    id: 4,
    name: "Garmin Forerunner 945",
    image: "https://flowbite-react.com/images/products/apple-watch.png",
    rating: 4.8,
    price: 499,
  },
  {
    id: 5,
    name: "Fossil Gen 5",
    image: "https://flowbite-react.com/images/products/apple-watch.png",
    rating: 4.2,
    price: 295,
  },
];

export default function Home() {
  const [searchQuery, setSearchQuery] = useState("");

  // Filtro de produtos com base na pesquisa
  const filteredProducts = products.filter((product) =>
    product.name.toLowerCase().includes(searchQuery.toLowerCase())
  );

  return (
    <main className="mb-24 flex min-h-screen flex-col gap-2 dark:bg-gray-800">
      <div className="container mx-auto">
        {/* Componente de busca */}
        <Search placeholder="Search products..." onSearch={setSearchQuery} />

        {/* Lista de produtos */}
        <div className="mt-3 grid grid-cols-4 gap-3">
          {filteredProducts.map((product) => (
            <ProductCard key={product.id} product={product} />
          ))}
        </div>

        {/* Categorias */}
        <div className="mt-24 grid grid-cols-12 gap-2">
          <div className="col-span-8 bg-gray-100 p-5">Categoria 1</div>
          <div className="col-span-4 bg-gray-100 p-5">Categoria 2</div>
          <div className="col-span-3 bg-gray-100 p-5">Categoria 3</div>
          <div className="col-span-9 bg-gray-100 p-5">Categoria 4</div>
        </div>
      </div>
    </main>
  );
}
