'use strict';

// An old style of traversing function's arguments
const oldMax = function () {
    let max = arguments[0];
    for (let i = 1; i < arguments.length; i++) {
        if (arguments[i] > max) {
            max = arguments[i];
        }
    }
    return max;
}

console.log('Find max by old style arguments:');
console.log(oldMax(10, 11, 30));

console.log('---------------');

// A new style of traversing function's arguments
const newMax = function (...numbers) {
    return numbers.reduce((max, current) => current > max ? current : max);
}

console.log('Find max by new rest style arguments:');
console.log(newMax(10, 11, 30));

const values = [33, 71, 55];
console.log('Pass arguments as spread:');
console.log(newMax(...values));
