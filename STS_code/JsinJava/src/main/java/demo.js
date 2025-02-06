           async function runTasks() {
                    await Promise.all(
                        new Promise(resolve => setTimeout(() => { a1.print1to10(); resolve(); }, 1000)),
                        new Promise(resolve => setTimeout(() => { b1.evenTill50(); resolve(); },1000)),
                        new Promise(resolve => setTimeout(() => { c1.fibonacciFrom1to1000(); resolve(); }, 1000))
                    ]);
                }
