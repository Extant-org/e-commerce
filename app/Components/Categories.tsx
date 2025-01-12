export default function Categories() {
    const categories = [
        {
            "id": 1,
            "name": "Smartwatches",
        }
    ];
    let i = 0;

    return (
        <div className="mt-24 grid grid-cols-12 gap-2">
            {categories.map((category) => {
                const colSpan = i % 2 === 0 ? '4' : '8';
                const element = (
                    // eslint-disable-next-line tailwindcss/no-custom-classname
                    <div key={category.id} className={`col-span-${colSpan} bg-gray-100 p-5`}>
                        {category.name}
                    </div>
                );
                i = i % 2 === 0 ? i * 2 : i + 1;
                return element;
            })}
            <div className="col-span-8 bg-gray-100 p-5">Categoria 1</div>
            <div className="col-span-4 bg-gray-100 p-5">Categoria 2</div>
            <div className="col-span-3 bg-gray-100 p-5">Categoria 3</div>
            <div className="col-span-9 bg-gray-100 p-5">Categoria 4</div>
        </div>
    );
}