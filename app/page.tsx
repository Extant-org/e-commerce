import { Carousel } from "flowbite-react"
import { ProductCard } from "@/app/Components/ProductCard"

export default function Home() {
  return (
    <main className="flex min-h-screen flex-col gap-2 dark:bg-gray-800 mb-24">
      <Carousel className="mt-24">
        <img
          src="https://flowbite.com/docs/images/carousel/carousel-1.svg"
          alt="..."
        />
        <img
          src="https://flowbite.com/docs/images/carousel/carousel-2.svg"
          alt="..."
        />
        <img
          src="https://flowbite.com/docs/images/carousel/carousel-3.svg"
          alt="..."
        />
        <img
          src="https://flowbite.com/docs/images/carousel/carousel-4.svg"
          alt="..."
        />
        <img
          src="https://flowbite.com/docs/images/carousel/carousel-5.svg"
          alt="..."
        />
      </Carousel>
      <div className="container-sm container mx-auto">
        <div className="grid grid-cols-4 gap-3">
          <ProductCard />
          <ProductCard />
          <ProductCard />
          <ProductCard />
          <ProductCard />
          <ProductCard />
        </div>
        <div className="grid grid-cols-12 gap-2 mt-24">
          <div className="col-span-8 bg-gray-100 p-5">Categoria 1</div>
          <div className="col-span-4 bg-gray-100 p-5">Categoria 2</div>
          <div className="col-span-3 bg-gray-100 p-5">Categoria 3</div>
          <div className="col-span-9 bg-gray-100 p-5">Categoria 4</div>
        </div>
      </div>
    </main>
  )
}
