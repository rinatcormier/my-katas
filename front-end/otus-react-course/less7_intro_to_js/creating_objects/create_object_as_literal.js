let example = {
    id: 123,
    name: 'John Doe',
    role: {
        role_id: 123,
        role_name: 'Admin',
    }
};

console.log(example);

/**
 A notion about prototype.
 Almost all JavaScript objects have second object called prototype.
 There is only one prototype object which is inherited by all objects
 that were created as literals.
 It's the Object.prototype.
 */
console.log(Object.prototype);
