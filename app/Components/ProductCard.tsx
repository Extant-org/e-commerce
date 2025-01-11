import { Card } from "flowbite-react"
import { Stars } from "./Stars";

interface ProductCardProps {
  product: {
    id: number;
    name: string;
    image: string;
    rating: number;
    price: number;
  };
}

export function ProductCard({ product }: ProductCardProps) {
  return (
    <Card
      className="max-w-sm"
      imgAlt={product.name}
      imgSrc={product.image}
    >
      <a href={`/products/${product.id}`}>
        <h5 className="text-xl font-semibold tracking-tight text-gray-900 dark:text-white">
          {product.name}
        </h5>
      </a>
      <div className="mb-5 mt-2.5 flex items-center">
        <Stars />
        <span className="ml-3 mr-2 rounded bg-cyan-100 px-2.5 py-0.5 text-xs font-semibold text-cyan-800 dark:bg-cyan-200 dark:text-cyan-800">
          {product.rating}
        </span>
      </div>
      <div className="flex items-center justify-between">
        <span className="text-3xl font-bold text-gray-900 dark:text-white">
          ${product.price}
        </span>
        <a
          href={`/products/${product.id}`}
          className="rounded-lg bg-cyan-700 px-5 py-2.5 text-center text-sm font-medium text-white hover:bg-cyan-800 focus:outline-none focus:ring-4 focus:ring-cyan-300 dark:bg-cyan-600 dark:hover:bg-cyan-700 dark:focus:ring-cyan-800"
        >
          Add to cart
        </a>
      </div>
    </Card>
  )
}
