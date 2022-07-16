describe('Create New User API', () =>{
    it('Add a new user', () => {
        var user = {
            "name": 'Halim',
            "job": 'Test Engineer'
        } 
        cy.request('POST', 'https:reqres.in/api/users', user).then((response) => {
            expect(response.body.name).equal('Halim')
            expect(response.body.job).equal('Test Engineer')
        })
    })
 
});