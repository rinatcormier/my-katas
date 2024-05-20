const names = ['Tom', 'Jerry'];

// An old style of iterating through an array
for (let i = 0; i < names.length; i++) {
    console.log(`${i} - ${names[i]}`);
}

console.log('---------------');

// A new style of iterating through an array
for (const [key, value] of names.entries()) {
    console.log(`${key} - ${value}`);
}
