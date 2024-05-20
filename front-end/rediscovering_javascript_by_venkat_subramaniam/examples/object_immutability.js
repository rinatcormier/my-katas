const mutable = {
    name: 'John Doe',
    age: 10,
};
console.log('Object before mutation:');
console.log(mutable);

mutable.age = 20;
console.log('Object after mutation:');

console.log('Is object frozen?');
console.log(Object.isFrozen(mutable));

console.log(mutable);

console.log('---------------');

const immutable = Object.freeze(mutable); // make object immutable

console.log('Immutable object before mutation:');
console.log(immutable);

immutable.age = 30;
console.log('Immutable object after mutation:');
console.log(immutable);

console.log('Is object frozen?');
console.log(Object.isFrozen(mutable)); // check if object is immutable

/**
 * If you want to throw exception on mutation immutable objects
 * then write 'use strict'; operator on top of file.
 */
