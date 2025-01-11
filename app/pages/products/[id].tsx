import { useRouter } from 'next/router';

export function Product() {

    const router = useRouter();
    const { id } = router.query;

    return (
        <main className="mb-24 flex min-h-screen flex-col gap-2 dark:bg-gray-800">
            {id}
        </main>
    );
}