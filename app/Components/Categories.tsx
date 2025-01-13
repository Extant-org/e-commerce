export default function Categories() {
    const categories = [
        {
            "id": 1,
            "name": "Smartwatches",
        },
        {
            "id": 2,
            "name": "Headphones",
        },
        {
            "id": 3,
            "name": "Laptops",
        },
        {
            "id": 4,
            "name": "Smartphones",
        },
        {
            "id": 5,
            "name": "Tablets",
        },
        {
            "id": 6,
            "name": "Cameras",
        },
    ];
    let i = 1;

    return (
        <div className="mt-24 grid grid-cols-12 gap-2">
            {categories.map((category) => {
                const colSpan = i % 2 === 0 ? '4' : '8';
                const element = (
                    // eslint-disable-next-line tailwindcss/no-custom-classname
                    <div key={category.id} className={`col-span-${colSpan} bg-gray-100 p-5`}>
                        {category.name} {i}
                    </div>
                );
                i = i % 2 === 0
                    ? i * 2
                    : i + 1;
                return element;
            })}
        </div>
    );
}